package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController5 {

    @GetMapping("/post/{firstName}")
    public String sayHelloPut(@PathVariable String firstName,
                              @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName + " from BridgeLabz";
    }
}



