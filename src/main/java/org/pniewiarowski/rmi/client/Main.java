package org.pniewiarowski.rmi.client;

import org.pniewiarowski.rmi.server.definition.RMIServerInterface;

import java.rmi.Naming;

public class Main {
    /**
     * The RMI binding name that clients will use to look up the server object.
     */
    private final static String SERVER_BINDING_NAME = "//localhost/RMIServer";

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");
            var remoteObject = (RMIServerInterface) Naming.lookup(SERVER_BINDING_NAME);

            var name = "Paweł";
            var resultForSayHelloMethod = remoteObject.sayHello(name);

            var additionTest = remoteObject.addition(2, 2, 5, 10);
            var subtractTest = remoteObject.subtract(100, 10, 10);
            var multiplyTest = remoteObject.multiply(10, 10, 10, 2);
            var divideTest = remoteObject.divide(100, 2, 2);

            System.out.printf("Response RMIServerInterface.sayHello(\"Paweł\"): %s%n", resultForSayHelloMethod);

            System.out.printf("Response RMIServerInterface.addition(2, 2, 5, 10): %f%n", additionTest);
            System.out.printf("Response RMIServerInterface.subtract(100, 10, 10): %f%n", subtractTest);
            System.out.printf("Response RMIServerInterface.multiply(10, 10, 10, 2): %f%n", multiplyTest);
            System.out.printf("Response RMIServerInterface.divide(100, 2, 2): %f%n", divideTest);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
