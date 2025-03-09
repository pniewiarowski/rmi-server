package org.pniewiarowski.rmi.client;

import org.pniewiarowski.rmi.server.definition.HelloRMIServerInterface;

import java.rmi.Naming;

public class HelloRMIClient {
    private final static String BINDING_NAME = "//localhost/HelloRMIServer";

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");

            var helloRMIRemote = (HelloRMIServerInterface) Naming.lookup(BINDING_NAME);
            var name = "Paweł";
            var resultForSayHelloMethod = helloRMIRemote.sayHello(name);

            System.out.printf("Response HelloRMIServerInterface.sayHello(\"Paweł\"): %s%n", resultForSayHelloMethod);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
