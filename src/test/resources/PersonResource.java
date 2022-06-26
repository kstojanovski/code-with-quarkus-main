package org.acme;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/AddressEntity")
public class PersonResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createEntry(String firstname, String lastname) {
//        AddressEntity AddressEntity = new AddressEntity();
//        AddressEntity.setFirstname(firstname);
//        AddressEntity.setLastname(lastname);
//        new PersonService().createPerson(AddressEntity);
    }

}