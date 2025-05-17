package com.example.demo.springconcepts.component;

import org.springframework.stereotype.Component;

@Component
public class DemoBean {

    public String getMessage() {
        return "This is a message from DemoBean!";
    }

    @Override
    public String toString() {
        return "DemoBean{}";
    }
}
