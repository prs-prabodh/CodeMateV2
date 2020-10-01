package com.app.codemate.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "health", produces = MediaType.APPLICATION_JSON_VALUE)
public class  HealthController {

    @GetMapping
    public String health() {
        return "success";
    }
}
