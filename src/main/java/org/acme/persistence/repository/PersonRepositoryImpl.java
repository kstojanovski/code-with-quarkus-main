package org.acme.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.persistence.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
@ApplicationScoped
public class PersonRepositoryImpl implements PanacheRepository<Person>, PersonRepository {

    @Transactional
    @Override
    public void createPerson(Person person){
        persistAndFlush(person);
    }

    @Override
    public Person getPerson(Long id) {
        return find("id", id).firstResult();
    }

    @Override
    public Person getPersonByFirstname(String firstname) {
        return find("firstName", firstname).firstResult();
    }

    @Override
    public Person getPersonByLastname(String lastname) {
        return find("lastname", lastname).firstResult();
    }

    @Transactional
    @Override
    public void createPerson(String firstname, String lastname) {
        Person person = new Person();
        person.setFirstname(firstname);
        person.setLastname(lastname);
        persistAndFlush(person);
    }

    public void deletePerson(Person person) {
        delete(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return listAll();
    }
}
