package com.learning.springBootBoilerPlate;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class HomeController {

    private String appVersion;

    public HomeController(@Value("${app.version}") String appVersion) {

        this.appVersion = appVersion;
    }

    @GetMapping
    @RequestMapping("/")
    public ResponseEntity index() {
        return ok("App Version: " + appVersion);
    }
}
