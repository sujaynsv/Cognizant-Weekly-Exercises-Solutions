package com.example1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive test suite for the Calculator class.
 * This test class validates all arithmetic operations provided by the Calculator
 * including edge cases and error conditions.
 * 
 * @author TDD Demo Project
 * @version 1.0
 */
@DisplayName("Mathematical Calculator Test Suite")
public class CalculatorTest {

    private Calculator mathematicalCalculator;

    @BeforeEach
    void initializeTestEnvironment() {
        mathematicalCalculator = new Calculator();
    }

    @Nested
    @DisplayName("Addition Operation Tests")
    class AdditionOperationTests {

        @Test
        @DisplayName("Should correctly add two positive integers")
        void shouldAddPositiveIntegersCorrectly() {
            // Given
            int firstNumber = 15;
            int secondNumber = 25;
            int expectedSum = 40;

            // When
            int actualResult = mathematicalCalculator.performAddition(firstNumber, secondNumber);

            // Then
            assertEquals(expectedSum, actualResult, 
                "Addition of two positive numbers should produce correct sum");
        }

        @Test
        @DisplayName("Should correctly add positive and negative integers")
        void shouldAddPositiveAndNegativeIntegersCorrectly() {
            // Given
            int positiveNumber = 10;
            int negativeNumber = -5;
            int expectedSum = 5;

            // When
            int actualResult = mathematicalCalculator.performAddition(positiveNumber, negativeNumber);

            // Then
            assertEquals(expectedSum, actualResult, 
                "Addition of positive and negative numbers should handle signs correctly");
        }

        @Test
        @DisplayName("Should handle addition with zero values")
        void shouldHandleAdditionWithZeroValues() {
            // Given
            int nonZeroValue = 42;
            int zeroValue = 0;

            // When & Then
            assertEquals(nonZeroValue, mathematicalCalculator.performAddition(nonZeroValue, zeroValue));
            assertEquals(nonZeroValue, mathematicalCalculator.performAddition(zeroValue, nonZeroValue));
            assertEquals(0, mathematicalCalculator.performAddition(zeroValue, zeroValue));
        }
    }

    @Nested
    @DisplayName("Subtraction Operation Tests")
    class SubtractionOperationTests {

        @Test
        @DisplayName("Should correctly subtract smaller from larger number")
        void shouldSubtractSmallerFromLargerNumber() {
            // Given
            int minuend = 20;
            int subtrahend = 8;
            int expectedDifference = 12;

            // When
            int actualResult = mathematicalCalculator.performSubtraction(minuend, subtrahend);

            // Then
            assertEquals(expectedDifference, actualResult);
        }

        @Test
        @DisplayName("Should handle subtraction resulting in negative number")
        void shouldHandleSubtractionResultingInNegative() {
            // Given
            int minuend = 5;
            int subtrahend = 15;
            int expectedDifference = -10;

            // When
            int actualResult = mathematicalCalculator.performSubtraction(minuend, subtrahend);

            // Then
            assertEquals(expectedDifference, actualResult);
        }
    }

    @Nested
    @DisplayName("Multiplication Operation Tests")
    class MultiplicationOperationTests {

        @Test
        @DisplayName("Should correctly multiply two positive integers")
        void shouldMultiplyPositiveIntegersCorrectly() {
            // Given
            int multiplicand = 6;
            int multiplier = 7;
            int expectedProduct = 42;

            // When
            int actualResult = mathematicalCalculator.performMultiplication(multiplicand, multiplier);

            // Then
            assertEquals(expectedProduct, actualResult);
        }

        @Test
        @DisplayName("Should handle multiplication by zero")
        void shouldHandleMultiplicationByZero() {
            // Given
            int anyNumber = 999;
            int zero = 0;

            // When & Then
            assertEquals(0, mathematicalCalculator.performMultiplication(anyNumber, zero));
            assertEquals(0, mathematicalCalculator.performMultiplication(zero, anyNumber));
        }
    }

    @Nested
    @DisplayName("Division Operation Tests")
    class DivisionOperationTests {

        @Test
        @DisplayName("Should correctly divide two integers")
        void shouldDivideIntegersCorrectly() {
            // Given
            int dividend = 20;
            int divisor = 4;
            double expectedQuotient = 5.0;

            // When
            double actualResult = mathematicalCalculator.performDivision(dividend, divisor);

            // Then
            assertEquals(expectedQuotient, actualResult, 0.001);
        }

        @Test
        @DisplayName("Should handle division with remainder")
        void shouldHandleDivisionWithRemainder() {
            // Given
            int dividend = 22;
            int divisor = 7;
            double expectedQuotient = 22.0 / 7.0;

            // When
            double actualResult = mathematicalCalculator.performDivision(dividend, divisor);

            // Then
            assertEquals(expectedQuotient, actualResult, 0.001);
        }

        @Test
        @DisplayName("Should throw exception when dividing by zero")
        void shouldThrowExceptionWhenDividingByZero() {
            // Given
            int dividend = 10;
            int divisorZero = 0;

            // When & Then
            ArithmeticException exception = assertThrows(ArithmeticException.class, 
                () -> mathematicalCalculator.performDivision(dividend, divisorZero));
            
            assertEquals("Division by zero is not permitted", exception.getMessage());
        }
    }
}