package org.pniewiarowski.rmi.server;

import org.pniewiarowski.rmi.calculator.Calculator;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
    /**
     * The port number on which the RMI registry will listen for incoming connections
     */
    private final static int PORT = 1099;

    /**
     * The RMI binding name that clients will use to look up the server object.
     */
    private final static String BINDING_NAME = "//localhost/RMIServer";

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");
            LocateRegistry.createRegistry(PORT);

            var calculator = new Calculator();
            var localTime = new LocalTime();
            var logger = new Logger();

            var server = new RMIServer(calculator, localTime, logger);

            Naming.rebind(BINDING_NAME, server);

            var message = String.format("RMIServer instance listening on port %d...", PORT);
            System.out.println(message);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
