package org.acme.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.persistence.entity.PersonAddress;
import org.acme.persistence.key.PersonAddressKey;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class PersonAddressRepositoryImpl implements PanacheRepository<PersonAddress> {

    @Transactional
    public void createPersonAddress(PersonAddress personAddress) {
        persistAndFlush(personAddress);
    }

    @Transactional
    public void mergePersonAddress(PersonAddress personAddress) {
        getEntityManager().merge(personAddress);
    }

    public PersonAddress getPersonAddress(PersonAddressKey personAddressKey) {
        return find("id", personAddressKey).firstResult();
    }
}
