package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Nation {
    private static final Logger LOGGER = LoggerFactory.getLogger(Nation.class);

    private String identifier;
    private String displayName;

    public Nation() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String fetchIdentifier() {
        LOGGER.debug("Getting country code: {}", identifier);
        return identifier;
    }

    public void assignIdentifier(String identifier) {
        LOGGER.debug("Setting country code: {}", identifier);
        this.identifier = identifier;
    }

    public String fetchDisplayName() {
        LOGGER.debug("Getting country name: {}", displayName);
        return displayName;
    }

    public void assignDisplayName(String displayName) {
        LOGGER.debug("Setting country name: {}", displayName);
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "Nation [identifier=" + identifier + ", displayName=" + displayName + "]";
    }
}