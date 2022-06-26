package org.acme.service;

import org.acme.persistence.entity.Person;
import org.acme.persistence.repository.PersonRepositoryImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
public class PersonService {

    @Inject
    PersonRepositoryImpl personRepositoryImpl;

    public List<Person> getAllPersons() {
        return personRepositoryImpl.getAllPersons();
    }

    public Person getPerson(Long id) {
        return personRepositoryImpl.getPerson(id);
    }

    public void createPerson(Person person) {
        personRepositoryImpl.createPerson(person);
    }

    public void createPerson(String firstname, String lastname) {
        personRepositoryImpl.createPerson(firstname, lastname);
    }

    @Transactional
    void deleteAll() {
        personRepositoryImpl.deleteAll();
    }
}
