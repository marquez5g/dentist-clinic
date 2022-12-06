package com.dh.dentistclinic.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String welcome() {
        return "<h1>Welcome, traveler.</h1>";
    }
}
