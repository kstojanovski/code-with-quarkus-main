package org.acme.service;

import org.acme.persistence.entity.AddressEntity;
import org.acme.persistence.repository.AddressRepositoryImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AddressService {

    @Inject
    AddressRepositoryImpl addressRepositoryImpl;

    public List<AddressEntity> getAllAddressEntities() {
        return addressRepositoryImpl.getAllAddressEntities();
    }

    public AddressEntity getAddressEntity(Long id) {
        return addressRepositoryImpl.getAddressEntity(id);
    }

    public void createPerson(AddressEntity addressEntity) {
        addressRepositoryImpl.createAddressEntity(addressEntity);
    }

    public void createAddressEntity(
            String street,
            String nr,
            String city,
            String zipPostal,
            String state,
            String country
    ) {
        addressRepositoryImpl.createAddressEntity(street, nr, city, zipPostal, state, country);
    }

    @Transactional
    void deleteAll() {
        addressRepositoryImpl.deleteAll();
    }
}
