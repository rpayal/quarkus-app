package com.co4gsl;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/greeting")
public class GreetingResource {

    public static final String DEFAULT_GREETING = "Namaste!!";

    @ConfigProperty(name = "greeting")
    public Optional<String> greeting;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting() {
        return greeting.orElse(DEFAULT_GREETING);
    }

    @GET
    @Path("/async")
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> asyncGreeting() {
        return CompletableFuture.supplyAsync(()->"Hi I'm async " + greeting.orElse(DEFAULT_GREETING));
    }
}