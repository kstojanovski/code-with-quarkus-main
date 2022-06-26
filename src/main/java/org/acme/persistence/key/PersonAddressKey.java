package org.acme.persistence.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PersonAddressKey implements Serializable {

    @Column(name = "person_id")
    Long personId;

    @Column(name = "address_id")
    Long addressId;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PersonAddressKey that = (PersonAddressKey) o;

        if (!personId.equals(that.personId))
            return false;
        return addressId.equals(that.addressId);
    }

    @Override
    public int hashCode() {
        int result = personId.hashCode();
        result = 31 * result + addressId.hashCode();
        return result;
    }
}
