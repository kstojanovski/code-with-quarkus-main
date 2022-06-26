package org.acme.persistence.entity;

import org.acme.persistence.key.PersonAddressKey;

import javax.persistence.*;

@Entity
public class PersonAddress {

    @EmbeddedId
    PersonAddressKey id;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    Person person;

    @ManyToOne
    @MapsId("addressId")
    @JoinColumn(name = "address_id")
    AddressEntity addressEntity;

    public PersonAddressKey getId() {
        return id;
    }

    public void setId(PersonAddressKey id) {
        this.id = id;
    }

    boolean isMainAddress;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public boolean isMainAddress() {
        return isMainAddress;
    }

    public void setMainAddress(boolean mainAddress) {
        isMainAddress = mainAddress;
    }
}
