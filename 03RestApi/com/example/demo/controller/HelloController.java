package com.example.demo.controller;

import com.example.demo.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final GreetingService greetingService;

    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "GET");
        response.put("message", greetingService.getSimpleGreeting());
        return response;
    }

    @PostMapping
    public Map<String, String> postGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "POST");
        response.put("message", greetingService.getSimpleGreeting());
        return response;
    }

    @PutMapping
    public Map<String, String> putGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "PUT");
        response.put("message", greetingService.getSimpleGreeting());
        return response;
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "DELETE");
        response.put("message", greetingService.getSimpleGreeting());
        return response;
    }
}
