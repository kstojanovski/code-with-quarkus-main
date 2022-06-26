package org.acme.service;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.integrationtest.TestContainersMariaDbTestResource;
import org.acme.persistence.entity.AddressEntity;
import org.acme.persistence.entity.Person;
import org.acme.persistence.entity.PersonAddress;
import org.acme.persistence.key.PersonAddressKey;
import org.acme.testutil.AddressTestConstants;
import org.acme.testutil.PersonTestConstants;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@QuarkusTestResource(TestContainersMariaDbTestResource.TestContainersMariaDbInitializer.class)
class PersonAddressServiceTest {

    @Inject
    PersonService personService;

    @Inject
    AddressService addressService;

    @Inject
    PersonAddressService personAddressService;


    @BeforeEach
    public void setUp() {
        personService.deleteAll();
        addressService.deleteAll();
    }

    /**
     * Sets in relation, already created Person and AddressEntity instances.
     */
    @Test
    void testMergePersonAddress() {
        //Arrange
        personService.createPerson(PersonTestConstants.FIRSTNAME, PersonTestConstants.LASTNAME);
        addressService.createAddressEntity(AddressTestConstants.STREET, AddressTestConstants.NR,
                AddressTestConstants.CITY, AddressTestConstants.ZIP_POSTAL, AddressTestConstants.STATE,
                AddressTestConstants.COUNTRY);
        final Person person = personService.getAllPersons().get(0);
        final AddressEntity addressEntity = addressService.getAllAddressEntities().get(0);
        // Composite key
        PersonAddressKey personAddressKey = createAndGetPersonAddressKey(person, addressEntity);

        //Act
        personAddressService.mergePersonAddress(personAddressKey, person, addressEntity);

        //Assert
        final PersonAddress personAddress = personAddressService.getPersonAddress(personAddressKey);
        assertNotNull(personAddress);
        assertTrue(personAddress.isMainAddress());
        assertEquals(PersonTestConstants.FIRSTNAME, personAddress.getPerson().getFirstname());
        assertEquals(AddressTestConstants.COUNTRY, personAddress.getAddressEntity().getCountry());
    }

    @NotNull
    private PersonAddressKey createAndGetPersonAddressKey(Person person, AddressEntity allAddressEntity) {
        PersonAddressKey personAddressKey = new PersonAddressKey();
        personAddressKey.setAddressId(allAddressEntity.getId());
        personAddressKey.setPersonId(person.getId());
        return personAddressKey;
    }

}