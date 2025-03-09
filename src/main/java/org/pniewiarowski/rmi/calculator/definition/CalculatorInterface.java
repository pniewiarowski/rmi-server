package org.pniewiarowski.rmi.calculator.definition;

/**
 * This interface defines basic arithmetic operations for a calculator.
 * The operations supported are addition, subtraction, multiplication, and division,
 * and they can accept a variable number of float values.
 */
public interface CalculatorInterface {
    /**
     * Adds the given values together.
     *
     * @param values The values to be added.
     *
     * @return The sum of the given values.
     */
    public float addition(float... values);

    /**
     * Subtracts all the given values from the specified base value.
     *
     * @param base The value from which all other values will be subtracted.
     * @param values The values to be subtracted from the base.
     *
     * @return The result of the subtraction.
     */
    public float subtract(float base, float... values);

    /**
     * Multiplies the given values together.
     *
     * @param values The values to be multiplied.
     *
     * @return The product of the given values.
     */
    public float multiply(float... values);

    /**
     * Divides the first value by the subsequent values.
     *
     * @param base The value to be divided.
     * @param values The values to divide the first value by.
     *
     * @return The result of the division.
     * @throws ArithmeticException If division by zero is attempted.
     */
    public float divide(float base, float... values) throws ArithmeticException;
}
