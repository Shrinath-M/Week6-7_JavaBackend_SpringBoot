package com.example.demo.service;

import com.example.demo.model.GreetingRecord;
import com.example.demo.repository.GreetingMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingMessageService {

    @Autowired
    private GreetingMessageRepository greetingMessageRepository;

    public String createAndSaveGreeting(String firstName, String lastName) {
        String message;

        if (firstName != null && !firstName.isBlank() && lastName != null && !lastName.isBlank()) {
            message = "Hello " + firstName + " " + lastName;
        } else if (firstName != null && !firstName.isBlank()) {
            message = "Hello " + firstName;
        } else if (lastName != null && !lastName.isBlank()) {
            message = "Hello " + lastName;
        } else {
            message = "Hello World";
        }

        greetingMessageRepository.save(new GreetingRecord(message));
        return message;
    }
}
