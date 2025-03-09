package org.pniewiarowski.rmi.calculator;

import org.pniewiarowski.rmi.calculator.definition.CalculatorInterface;

public class Calculator implements CalculatorInterface {

    @Override
    public float addition(float... values) {
        var result = 0.00f;
        for (float value : values) {
            result += value;
        }

        return result;
    }

    @Override
    public float subtract(float base, float... values) {
        for (float value : values) {
            base -= value;
        }

        return base;
    }

    @Override
    public float multiply(float... values) {
        if (values.length == 0) {
            return 0.0f;
        }

        var result = values[0];

        for (float value : values) {
            result *= value;
        }

        return result;
    }

    @Override
    public float divide(float base, float... values) throws ArithmeticException {
        for (float value : values) {
            if (value == 0) {
                throw new ArithmeticException();
            }

            base /= value;
        }

        return base;
    }
}
