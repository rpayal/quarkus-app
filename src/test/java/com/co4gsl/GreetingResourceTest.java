package com.co4gsl;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

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
}