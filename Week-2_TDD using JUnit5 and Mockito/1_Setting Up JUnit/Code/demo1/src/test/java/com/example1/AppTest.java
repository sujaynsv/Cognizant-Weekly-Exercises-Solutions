package com.example1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test suite for the main application components.
 * This test class serves as a comprehensive validation framework
 * for ensuring the overall application functionality and stability.
 * 
 * @author TDD Demo Project
 * @version 1.0
 */
@DisplayName("Application Integration Test Suite")
class AppTest {
    
    private Calculator applicationCalculator;
    
    @BeforeEach
    void setupTestEnvironment() {
        applicationCalculator = new Calculator();
        System.out.println("Test environment initialized successfully");
    }
    
    @AfterEach
    void cleanupTestEnvironment() {
        applicationCalculator = null;
        System.out.println("Test environment cleaned up");
    }

    /**
     * Validates the basic application setup and component initialization.
     * This test ensures that core mathematical operations are functioning
     * as expected within the application context.
     */
    @Test
    @DisplayName("Application should initialize and perform basic calculations correctly")
    void applicationShouldInitializeAndCalculateCorrectly() {
        // Verify that calculator instance is properly created
        assertNotNull(applicationCalculator, "Calculator instance should not be null");
        
        // Perform basic operational verification
        int additionResult = applicationCalculator.performAddition(3, 4);
        assertEquals(7, additionResult, "Basic addition should work in application context");
        
        int subtractionResult = applicationCalculator.performSubtraction(10, 6);
        assertEquals(4, subtractionResult, "Basic subtraction should work in application context");
        
        int multiplicationResult = applicationCalculator.performMultiplication(5, 3);
        assertEquals(15, multiplicationResult, "Basic multiplication should work in application context");
        
        double divisionResult = applicationCalculator.performDivision(12, 4);
        assertEquals(3.0, divisionResult, 0.001, "Basic division should work in application context");
    }
    
    /**
     * Stress test for application stability under repeated operations.
     * This ensures the application maintains consistency across multiple calculations.
     */
    @RepeatedTest(5)
    @DisplayName("Application should maintain stability across repeated calculations")
    void applicationShouldMaintainStabilityAcrossRepeatedCalculations() {
        // Test repeated calculations to ensure consistency
        for (int i = 1; i <= 10; i++) {
            int result = applicationCalculator.performAddition(i, i);
            assertEquals(i * 2, result, "Repeated calculations should remain consistent");
        }
    }
    
    /**
     * Validates that the application handles edge cases appropriately.
     * This test covers boundary conditions and error scenarios.
     */
    @Test
    @DisplayName("Application should handle edge cases and error conditions gracefully")
    void applicationShouldHandleEdgeCasesGracefully() {
        // Test with maximum integer values
        int maxValueTest = applicationCalculator.performSubtraction(Integer.MAX_VALUE, 1);
        assertEquals(Integer.MAX_VALUE - 1, maxValueTest);
        
        // Test with minimum integer values
        int minValueTest = applicationCalculator.performAddition(Integer.MIN_VALUE, 1);
        assertEquals(Integer.MIN_VALUE + 1, minValueTest);
        
        // Test division by zero error handling
        assertThrows(ArithmeticException.class, 
            () -> applicationCalculator.performDivision(5, 0),
            "Application should properly handle division by zero");
    }
    
    /**
     * Comprehensive integration test that validates the entire calculation workflow.
     * This test simulates a real-world usage scenario of the calculator application.
     */
    @Test
    @DisplayName("Application should support complex calculation workflows")
    void applicationShouldSupportComplexCalculationWorkflows() {
        // Simulate a complex calculation workflow: ((10 + 5) * 3) / 5
        int step1 = applicationCalculator.performAddition(10, 5);        // 15
        int step2 = applicationCalculator.performMultiplication(step1, 3); // 45
        double finalResult = applicationCalculator.performDivision(step2, 5); // 9.0
        
        assertEquals(9.0, finalResult, 0.001, 
            "Complex calculation workflow should produce expected result");
    }
}
