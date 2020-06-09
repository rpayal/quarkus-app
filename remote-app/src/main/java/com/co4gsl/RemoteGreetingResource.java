package com.co4gsl;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/remote-greeting")
public class RemoteGreetingResource {

    public static final String DEFAULT_GREETING = "Remote Namaste!!";

    @ConfigProperty(name = "greeting")
    public Optional<String> remoteGreeting;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String remoteGreeting() {
        return remoteGreeting.orElse(DEFAULT_GREETING);
    }
}