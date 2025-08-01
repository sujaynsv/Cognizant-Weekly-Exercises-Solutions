package com.cognizant.spring_learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class GreetingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/hello")
    public String provideGreeting() {
        LOGGER.info("START - sayHello()");
        String greetingMsg = "Hello World!!";
        LOGGER.info("END - sayHello()");
        return greetingMsg;
    }
}
