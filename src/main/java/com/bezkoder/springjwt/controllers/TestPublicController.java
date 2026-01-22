package com.bezkoder.springjwt.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/public")
public class TestPublicController {

    @GetMapping("/ping")
    public String ping() {
        return "Public API OK";
    }

    @GetMapping("/health")
    public String health() {
        return "Service is running";
    }

    @GetMapping("/test")
    public String test() {
        return "Public test success";
    }
}
