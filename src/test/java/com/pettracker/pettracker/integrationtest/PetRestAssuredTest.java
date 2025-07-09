package com.pettracker.pettracker.integrationtest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PetRestAssuredTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost/";
        RestAssured.port = port;
    }

    @Test
    public void testPostPetAndGetOutsideZone() {
        // Create pet
        String petJson = """
            {
              "petType": "DOG",
              "trackerType": "SMALL",
              "ownerId": 101,
              "inZone": false
            }
            """;

        given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body(petJson)
                .when()
                .post("/pets/save")
                .then()
                .statusCode(200)
                .body("petType", equalTo("DOG"));

        // Fetch pets outside zone
        when()
                .get("/pets/outside-zone")
                .then()
                .statusCode(200)
                .body("DOG-SMALL", equalTo(1));
    }

    @Test
    public void testGetAllPets() {
        when()
                .get("/pets/all-pets")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$", not(empty()));
    }
}
