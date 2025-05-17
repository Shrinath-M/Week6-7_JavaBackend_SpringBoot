package com.example.demo.springconcepts;

import com.example.demo.springconcepts.component.DemoBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringConceptsApplication {

    public static final Logger logger = LoggerFactory.getLogger(SpringConceptsApplication.class);

    public static void main(String[] args) {
        logger.debug("Welcome to Spring Concept Demo");
        ApplicationContext context = SpringApplication.run(SpringConceptsApplication.class, args);
        logger.debug("Checking Context: {}", context.getBean(DemoBean.class));
        logger.debug("***** Example Using @Autowire annotation on property *****");
    }
}
