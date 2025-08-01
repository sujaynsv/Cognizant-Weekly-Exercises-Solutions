package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService serviceInstance;

    @BeforeEach
    public void initializeTest() {
        serviceInstance = new UserService();
        System.out.println("Setup completed.");
    }

    @Test
    public void shouldReturnTrueForValidUsername() {
        String inputUsername = "Sujay_123";
        
        boolean validationResult = serviceInstance.isValidUsername(inputUsername);
        
        assertTrue(validationResult);
    }

    @Test
    public void shouldReturnFalseForInvalidUsername() {
        String inputUsername = "no!";
        
        boolean validationResult = serviceInstance.isValidUsername(inputUsername);
        
        assertFalse(validationResult);
    }

    @AfterEach
    public void cleanupTest() {
        serviceInstance.disconnect();
        System.out.println("Teardown completed.");
    }
}
