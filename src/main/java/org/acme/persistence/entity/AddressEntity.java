package org.acme.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "Address")
@Entity
public class AddressEntity {

    private Long id;

    private String street;
    private String nr;
    private String city;
    private String zipPostal;
    private String state;
    private String country;

    @Id
    @SequenceGenerator(name = "addressSeq", sequenceName = "address_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "addressSeq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "addressEntity")
    Set<PersonAddress> personAddress;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipPostal() {
        return zipPostal;
    }

    public void setZipPostal(String zipPostal) {
        this.zipPostal = zipPostal;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
