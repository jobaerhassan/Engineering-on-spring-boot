package com.own.eosp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomController {

    @GetMapping("/")
    public String home() {
        return "Hello, World!";
    }
}
