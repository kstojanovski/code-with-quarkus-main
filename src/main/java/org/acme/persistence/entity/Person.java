package org.acme.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Person {
    private Long id;
    private String firstname;
    private String lastname;

    @Id
    @SequenceGenerator(name = "personSeq", sequenceName = "person_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "personSeq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @SuppressWarnings("unused")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }

    @SuppressWarnings("unused")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @OneToMany(mappedBy = "person")
    Set<PersonAddress> personAddress;
}
