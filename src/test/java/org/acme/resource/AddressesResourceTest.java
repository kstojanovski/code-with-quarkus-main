package org.acme.resource;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.integrationtest.TestContainersMariaDbTestResource;
import org.acme.persistence.entity.AddressEntity;
import org.acme.persistence.entity.Person;
import org.acme.service.AddressService;
import org.acme.service.PersonAddressService;
import org.acme.service.PersonService;
import org.acme.testutil.AddressTestConstants;
import org.acme.testutil.EntitySerializer;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(TestContainersMariaDbTestResource.TestContainersMariaDbInitializer.class)
class AddressesResourceTest {

    EntitySerializer entitySerializer = new EntitySerializer();

    @Inject
    AddressService addressService;

    @Test
    void testHelloEndpoint() {
        // Arrange
        // add entity into db
        addressService.createAddressEntity(AddressTestConstants.STREET, AddressTestConstants.NR,
                AddressTestConstants.CITY, AddressTestConstants.ZIP_POSTAL, AddressTestConstants.STATE,
                AddressTestConstants.COUNTRY);
        // get serialize persons to JSON
        final String serializedPerson = entitySerializer.serializeEntity(createAddressEntity());

        //Act And Assert
        given()
                .when().get("/addresses")
                .then()
                .statusCode(200)
                .body(is(serializedPerson));
    }

    private List<AddressEntity> createAddressEntity() {
        List<AddressEntity> persons = new ArrayList<>();
        final AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(1L);
        addressEntity.setCountry(AddressTestConstants.COUNTRY);
        addressEntity.setCity(AddressTestConstants.CITY);
        addressEntity.setZipPostal(AddressTestConstants.ZIP_POSTAL);
        addressEntity.setNr(AddressTestConstants.NR);
        addressEntity.setState(AddressTestConstants.STATE);
        addressEntity.setStreet(AddressTestConstants.STREET);
        persons.add(addressEntity);
        return persons;
    }

}