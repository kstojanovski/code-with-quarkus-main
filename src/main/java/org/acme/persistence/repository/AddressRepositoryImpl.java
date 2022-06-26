package org.acme.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.persistence.entity.AddressEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AddressRepositoryImpl implements PanacheRepository<AddressEntity>, AddressRepository {

    @Transactional
    @Override
    public void createAddressEntity(AddressEntity addressEntity){
        persistAndFlush(addressEntity);
    }

    @Override
    public AddressEntity getAddressEntity(Long id) {
        return find("id", id).firstResult();
    }

    @Transactional
    @Override
    public void createAddressEntity(
            String street,
            String nr,
            String city,
            String zipPostal,
            String state,
            String country
    ) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(street);
        addressEntity.setNr(nr);
        addressEntity.setCity(city);
        addressEntity.setZipPostal(zipPostal);
        addressEntity.setState(state);
        addressEntity.setCountry(country);
        persistAndFlush(addressEntity);
    }

    public void deleteAddressEntity(AddressEntity addressEntity) {
        delete(addressEntity);
    }

    @Override
    public List<AddressEntity> getAllAddressEntities() {
        return listAll();
    }

}
