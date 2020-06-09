package com.co4gsl;

import io.quarkus.test.junit.NativeImageTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@NativeImageTest
public class NativeRemoteGreetingResourceIT extends RemoteGreetingResourceTest {

    @Test
    public void testGreetingEndpoint() {
        given()
                .when().get("/remote-greeting")
                .then()
                .statusCode(200)
                .body(is("Remote Bonjour!!"));
    }
}