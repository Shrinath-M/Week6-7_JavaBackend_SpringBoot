package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController1 {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from BridgeLabz";
    }
}
