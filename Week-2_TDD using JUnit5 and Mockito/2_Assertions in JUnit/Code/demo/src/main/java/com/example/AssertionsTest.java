package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 assertions demonstration class
 * Validates various assertion methods with different test scenarios
 */
public class AssertionsTest {

    @Test
    @DisplayName("Verify mathematical equality assertions")
    public void validateMathematicalEquality() {
        // Test basic arithmetic operation
        int expectedSum = 5;
        int actualResult = 2 + 3;
        assertEquals(expectedSum, actualResult);
    }

    @Test
    @DisplayName("Verify boolean condition assertions")
    public void validateBooleanConditions() {
        // Test positive condition
        int smallerNumber = 3;
        int largerNumber = 5;
        assertTrue(smallerNumber < largerNumber);
        
        // Test negative condition
        assertFalse(largerNumber < smallerNumber);
    }

    @Test
    @DisplayName("Verify null value assertions")
    public void validateNullValues() {
        // Test null assertion
        Object nullObject = null;
        assertNull(nullObject);
        
        // Test non-null assertion
        String testString = "JUnit";
        assertNotNull(testString);
    }
}