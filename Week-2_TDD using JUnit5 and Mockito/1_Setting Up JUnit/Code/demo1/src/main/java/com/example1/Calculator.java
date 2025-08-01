package com.example1;

/**
 * A comprehensive mathematical calculator that provides basic arithmetic operations.
 * This utility class is designed to handle fundamental mathematical computations
 * with robust input validation and error handling.
 * 
 * @author TDD Demo Project
 * @version 1.0
 */
public class Calculator {
    
    /**
     * Performs addition operation on two integer values.
     * 
     * @param firstOperand  the first number to be added
     * @param secondOperand the second number to be added
     * @return the sum of firstOperand and secondOperand
     * @throws ArithmeticException if the result would cause integer overflow
     */
    public int performAddition(int firstOperand, int secondOperand) {
        // Check for potential overflow before performing addition
        if (firstOperand > 0 && secondOperand > Integer.MAX_VALUE - firstOperand) {
            throw new ArithmeticException("Integer overflow detected during addition operation");
        }
        if (firstOperand < 0 && secondOperand < Integer.MIN_VALUE - firstOperand) {
            throw new ArithmeticException("Integer underflow detected during addition operation");
        }
        
        return firstOperand + secondOperand;
    }
    
    /**
     * Performs subtraction operation between two integer values.
     * 
     * @param minuend    the number from which to subtract
     * @param subtrahend the number to be subtracted
     * @return the difference between minuend and subtrahend
     */
    public int performSubtraction(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }
    
    /**
     * Performs multiplication operation on two integer values.
     * 
     * @param multiplicand the first number to multiply
     * @param multiplier   the second number to multiply
     * @return the product of multiplicand and multiplier
     */
    public int performMultiplication(int multiplicand, int multiplier) {
        return multiplicand * multiplier;
    }
    
    /**
     * Performs division operation on two integer values.
     * 
     * @param dividend the number to be divided
     * @param divisor  the number by which to divide
     * @return the quotient of dividend divided by divisor
     * @throws ArithmeticException if divisor is zero
     */
    public double performDivision(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero is not permitted");
        }
        return (double) dividend / divisor;
    }
}
