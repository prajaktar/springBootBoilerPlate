package com.learning.springBootBoilerPlate;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.http.HttpStatus.OK;

class HomeControllerTest {
    HomeController homeController;

    @Test
    void index_shouldShowAppVersion() {
        homeController = new HomeController("1.0");

        ResponseEntity actual = homeController.index();

        assertThat(actual.getStatusCode().value(), Is.is(OK.value()));
        assertThat(actual.getBody(), Is.is("App Version: 1.0"));
    }
}