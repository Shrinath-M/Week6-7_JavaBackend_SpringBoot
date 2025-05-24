package com.example.demo.controller;

import com.example.demo.model.GreetingRecord;
import com.example.demo.repository.GreetingMessageRepository;
import com.example.demo.service.GreetingMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saved-greeting")
public class GreetingMessageController {

    @Autowired
    private GreetingMessageService greetingMessageService;

    @Autowired
    private GreetingMessageRepository greetingMessageRepository;

    @GetMapping
    public String getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingMessageService.createAndSaveGreeting(firstName, lastName);
    }
    
    @GetMapping("/{id}")
    public GreetingRecord getGreetingById(@PathVariable Long id) {
        return greetingMessageRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Greeting not found with id: " + id));
    }

    
    @PostMapping("/save")
    public GreetingRecord saveGreeting(@RequestBody GreetingRecord greeting) {
        return greetingMessageRepository.save(greeting);
    }

    @GetMapping("/all")
    public List<GreetingRecord> getAll() {
        return greetingMessageRepository.findAll();
    }
    
    @PutMapping("/update/{id}")
    public GreetingRecord updateGreeting(@PathVariable Long id, @RequestBody GreetingRecord newGreeting) {
        return greetingMessageRepository.findById(id)
            .map(greeting -> {
                greeting.setMessage(newGreeting.getMessage());
                return greetingMessageRepository.save(greeting);
            })
            .orElseThrow(() -> new RuntimeException("Greeting not found with id " + id));
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        if (!greetingMessageRepository.existsById(id)) {
            return "Greeting not found with id " + id;
        }
        greetingMessageRepository.deleteById(id);
        return "Greeting deleted with id " + id;
    }


}
