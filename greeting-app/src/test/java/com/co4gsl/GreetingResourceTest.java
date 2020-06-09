package com.co4gsl;

import com.co4gsl.client.GreetingClient;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @InjectMock
    @RestClient
    GreetingClient greetingClient;

    @Test
    public void testGreetingEndpoint() {
        given()
          .when().get("/greeting")
          .then()
             .statusCode(200)
             .body(is("Bonjour!!"));
    }

    @Test
    public void testAsyncGreetingEndpoint() {
        given()
                .when().get("/greeting/async")
                .then()
                .statusCode(200)
                .body(is("Hi I'm async Bonjour!!"));
    }

    @Test
    public void testRemoteGreetingEndpoint() {
        Mockito.when(greetingClient.remoteGreeting()).thenReturn("Remote Greeting!!");
        given()
                .when().get("/greeting/remote")
                .then()
                .statusCode(200)
                .body(is("Remote Greeting!!"));
    }
}