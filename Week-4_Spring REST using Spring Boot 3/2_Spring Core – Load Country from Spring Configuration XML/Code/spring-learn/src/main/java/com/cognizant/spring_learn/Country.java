package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Nation {
    private static final Logger LOGGER = LoggerFactory.getLogger(Nation.class);

    private String identifier;
    private String label;

    public Nation() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String obtainIdentifier() {
        LOGGER.debug("Getting code: {}", identifier);
        return identifier;
    }

    public void updateIdentifier(String identifier) {
        LOGGER.debug("Setting code: {}", identifier);
        this.identifier = identifier;
    }

    public String obtainLabel() {
        LOGGER.debug("Getting name: {}", label);
        return label;
    }

    public void updateLabel(String label) {
        LOGGER.debug("Setting name: {}", label);
        this.label = label;
    }

    @Override
    public String toString() {
        return "Nation [identifier=" + identifier + ", label=" + label + "]";
    }
}
