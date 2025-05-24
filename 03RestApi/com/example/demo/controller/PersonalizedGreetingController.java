package com.example.demo.controller;

import com.example.demo.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greet")
public class PersonalizedGreetingController {

    private final GreetingService greetingService;

    public PersonalizedGreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Map<String, String> getPersonalizedGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) {
        Map<String, String> response = new HashMap<>();
        response.put("method", "GET");
        response.put("message", greetingService.getGreeting(firstName, lastName));
        return response;
    }
}
