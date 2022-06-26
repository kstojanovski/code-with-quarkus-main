package org.acme.resource;

import org.acme.persistence.entity.AddressEntity;
import org.acme.service.AddressService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/addresses")
public class AddressesResource {

    @Inject
    AddressService addressService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AddressEntity> getAllAddresses() {
        return addressService.getAllAddressEntities();
    }

}