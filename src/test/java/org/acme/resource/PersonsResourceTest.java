package org.acme.resource;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.integrationtest.TestContainersMariaDbTestResource;
import org.acme.persistence.entity.Person;
import org.acme.service.PersonService;
import org.acme.testutil.EntitySerializer;
import org.acme.testutil.PersonTestConstants;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(TestContainersMariaDbTestResource.TestContainersMariaDbInitializer.class)
class PersonsResourceTest {

    EntitySerializer entitySerializer = new EntitySerializer();

    @Inject
    PersonService personService;

    @Test
    void testHelloEndpoint() {
        // Arrange
        // add entity into db
        personService.createPerson(PersonTestConstants.FIRSTNAME, PersonTestConstants.LASTNAME);
        // get serialize persons to JSON
        final String serializedPerson = entitySerializer.serializeEntity(createPersons());

        //Act And Assert
        given()
          .when().get("/persons")
          .then()
             .statusCode(200)
                .body(is(serializedPerson));
    }

    @NotNull
    private List<Person> createPersons() {
        List<Person> persons = new ArrayList<>();
        final Person person = new Person();
        person.setId(1L);
        person.setFirstname(PersonTestConstants.FIRSTNAME);
        person.setLastname(PersonTestConstants.LASTNAME);
        persons.add(person);
        return persons;
    }

}