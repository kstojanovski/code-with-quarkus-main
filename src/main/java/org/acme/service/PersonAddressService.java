package org.acme.service;

import org.acme.persistence.entity.AddressEntity;
import org.acme.persistence.entity.Person;
import org.acme.persistence.entity.PersonAddress;
import org.acme.persistence.key.PersonAddressKey;
import org.acme.persistence.repository.PersonAddressRepositoryImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PersonAddressService {

    @Inject
    PersonAddressRepositoryImpl personAddressRepositoryImpl;

    public PersonAddress getPersonAddress(PersonAddressKey personAddressKey) {
        return personAddressRepositoryImpl.getPersonAddress(personAddressKey);
    }

    public void createPersonAddress(PersonAddressKey id, Person person, AddressEntity addressEntity) {
        PersonAddress personAddress = new PersonAddress();
        personAddress.setId(id);
        personAddress.setPerson(person);
        personAddress.setAddressEntity(addressEntity);
        personAddress.setMainAddress(true);
        personAddressRepositoryImpl.createPersonAddress(personAddress);
    }

    public void createPersonAddress(PersonAddressKey id) {
        PersonAddress personAddress = new PersonAddress();
        personAddress.setId(id);
        personAddress.setMainAddress(true);
        personAddressRepositoryImpl.createPersonAddress(personAddress);
    }

    public void mergePersonAddress(PersonAddressKey id, Person person, AddressEntity addressEntity) {
        PersonAddress personAddress = new PersonAddress();
        personAddress.setId(id);
        personAddress.setPerson(person);
        personAddress.setAddressEntity(addressEntity);
        personAddress.setMainAddress(true);
        personAddressRepositoryImpl.mergePersonAddress(personAddress);
    }

}
