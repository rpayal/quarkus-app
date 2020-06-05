package com.co4gsl;

import com.co4gsl.entity.Developer;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class DeveloperResourceTest {

    @Test
    public void testDeveloper() {
        given()
                .when().get("/developer")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    public void testAddDeveloper() {
        String payload = "{\n" +
                "  \"id\": 0,\n" +
                "  \"name\": \"Bill Gates\"\n" +
                "}";
        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/developer")
                .then()
                .statusCode(200);
    }
}
