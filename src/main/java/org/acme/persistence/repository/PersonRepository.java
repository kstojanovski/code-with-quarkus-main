package org.acme.persistence.repository;

import org.acme.persistence.entity.Person;

import java.util.List;

public interface PersonRepository {

    Person getPerson(Long id);

    Person getPersonByFirstname(String firstname);

    Person getPersonByLastname(String lastname);

    void createPerson(String firstname, String lastname);

    void deletePerson(Person person);

    List<Person> getAllPersons();

    void createPerson(Person person);
}
