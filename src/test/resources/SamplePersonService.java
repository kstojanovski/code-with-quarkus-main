package org.acme.service;

import org.acme.entity.AddressEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class SamplePersonService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public void createPerson(String firstname, String lastname) {
        AddressEntity AddressEntity = new AddressEntity();
        AddressEntity.setFirstname(firstname);
        AddressEntity.setLastname(lastname);
        entityManager.persist(AddressEntity);
    }
    
}
