package com.learning.springBootBoilerPlate;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.springframework.http.HttpStatus.OK;

class HomeControllerIntegrationTest {

    @Test
    void index_shouldGiveAppVersion() {
        RestAssuredMockMvc.standaloneSetup(new HomeController("1.0"));

        given().when()
                .get("/")
                .then()
                .statusCode(OK.value())
                .body(Is.is("1.0"));
    }
}