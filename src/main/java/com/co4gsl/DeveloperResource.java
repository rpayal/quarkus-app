package com.co4gsl;

import com.co4gsl.entity.Developer;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/developer")
public class DeveloperResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Developer> developers() {
        return Developer.listAll();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Developer addDeveloper(Developer developer) {
        developer.id=null;
        developer.persist();
        return developer;
    }
}
