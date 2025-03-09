package org.pniewiarowski.rmi.client;

import org.pniewiarowski.rmi.server.definition.server.CalculatorRMIServerInterface;
import org.pniewiarowski.rmi.server.definition.server.HelloRMIServerInterface;
import org.pniewiarowski.rmi.server.definition.server.ProductRMIServerInterface;

import java.rmi.Naming;

public class Main {
    /**
     * Bindings for RMI servers.
     */
    private final static String HELLO_BINDING_NAME = "//localhost/HelloRMIServer";
    private final static String CALCULATOR_BINDING_NAME = "//localhost/CalculatorRMIServer";
    private final static String PRODUCT_BINDING_NAME = "//localhost/ProductRMIServer";

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");

            var helloRMIRemote = (HelloRMIServerInterface) Naming.lookup(HELLO_BINDING_NAME);
            var calculatorRMIRemote = (CalculatorRMIServerInterface) Naming.lookup(CALCULATOR_BINDING_NAME);
            var productRMIRemote = (ProductRMIServerInterface) Naming.lookup(PRODUCT_BINDING_NAME);

            var name = "Paweł";
            var resultForSayHelloMethod = helloRMIRemote.sayHello(name);

            var additionResult = calculatorRMIRemote.addition(2, 2, 5, 10);
            var subtractResult = calculatorRMIRemote.subtract(100, 10, 10);
            var multiplyResult = calculatorRMIRemote.multiply(10, 10, 10, 2);
            var divideResult = calculatorRMIRemote.divide(100, 2, 2);

            var getCollectionOfProductsResult = productRMIRemote.findAllProducts();
            var getProductByIDResult = productRMIRemote.findProductByID(3);

            System.out.printf("Response HelloRMIServerInterface.sayHello(\"Paweł\"): %s%n", resultForSayHelloMethod);

            System.out.printf("Response RMIServerInterface.addition(2, 2, 5, 10): %f%n", additionResult);
            System.out.printf("Response RMIServerInterface.subtract(100, 10, 10): %f%n", subtractResult);
            System.out.printf("Response RMIServerInterface.multiply(10, 10, 10, 2): %f%n", multiplyResult);
            System.out.printf("Response RMIServerInterface.divide(100, 2, 2): %f%n", divideResult);

            System.out.printf("Response RMIServerInterface.getCollectionOfProducts(): %s%n", getCollectionOfProductsResult);
            System.out.printf("Response RMIServerInterface.getProductByID(3): %s%n", getProductByIDResult);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
