package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    // Create a logger specific to this class
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Output error and warning messages using SLF4J
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}

