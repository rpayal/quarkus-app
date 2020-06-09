package com.co4gsl.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@RegisterRestClient
@Path("/remote-greeting")
public interface GreetingClient {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String remoteGreeting();
}
