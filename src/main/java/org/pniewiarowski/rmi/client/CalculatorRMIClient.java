package org.pniewiarowski.rmi.client;

import org.pniewiarowski.rmi.server.definition.server.CalculatorRMIServerInterface;

import java.rmi.Naming;

public class CalculatorRMIClient {
    /**
     * Binding for RMI server.
     */
    private final static String CALCULATOR_BINDING_NAME = "//localhost/CalculatorRMIServer";

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");

            var calculatorRMIRemote = (CalculatorRMIServerInterface) Naming.lookup(CALCULATOR_BINDING_NAME);
            var additionResult = calculatorRMIRemote.addition(2, 2, 5, 10);
            var subtractResult = calculatorRMIRemote.subtract(100, 10, 10);
            var multiplyResult = calculatorRMIRemote.multiply(10, 10, 10, 2);
            var divideResult = calculatorRMIRemote.divide(100, 2, 2);

            System.out.printf("Response RMIServerInterface.addition(2, 2, 5, 10): %f%n", additionResult);
            System.out.printf("Response RMIServerInterface.subtract(100, 10, 10): %f%n", subtractResult);
            System.out.printf("Response RMIServerInterface.multiply(10, 10, 10, 2): %f%n", multiplyResult);
            System.out.printf("Response RMIServerInterface.divide(100, 2, 2): %f%n", divideResult);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
