package org.acme.persistence.repository;

import org.acme.persistence.entity.AddressEntity;

import java.util.List;

public interface AddressRepository {

    AddressEntity getAddressEntity(Long id);

    void createAddressEntity(
            String street,
            String nr,
            String city,
            String zipPostal,
            String state,
            String country
    );

    void deleteAddressEntity(AddressEntity addressEntity);

    List<AddressEntity> getAllAddressEntities();

    void createAddressEntity(AddressEntity addressEntity);

}
