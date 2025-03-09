package org.pniewiarowski.rmi.server;

import org.pniewiarowski.rmi.calculator.Calculator;
import org.pniewiarowski.rmi.server.server.CalculatorRMIServer;
import org.pniewiarowski.rmi.server.server.ChatRMIServer;
import org.pniewiarowski.rmi.server.server.HelloRMIServer;
import org.pniewiarowski.rmi.server.server.ProductRMIServer;
import org.pniewiarowski.rmi.time.LocalTime;
import org.pniewiarowski.rmi.logger.Logger;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
    /**
     * The port number on which the RMI registry will listen for incoming connections
     */
    private final static int PORT = 1099;

    /**
     * Binding for RMI servers.
     */
    private final static String HELLO_BINDING_NAME = "//localhost/HelloRMIServer";
    private final static String CALCULATOR_BINDING_NAME = "//localhost/CalculatorRMIServer";
    private final static String PRODUCT_BINDING_NAME = "//localhost/ProductRMIServer";
    private final static String CHAT_BINDING_NAME = "//localhost/ChatRMIServer";

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");
            LocateRegistry.createRegistry(PORT);

            var calculator = new Calculator();
            var localTime = new LocalTime();
            var logger = new Logger();

            var helloRMIServer = new HelloRMIServer(localTime, logger);
            var calculatorRMIServer = new CalculatorRMIServer(localTime, logger, calculator);
            var productRMIServer = new ProductRMIServer(localTime, logger);
            var chatRMIServer = new ChatRMIServer(localTime, logger);

            Naming.rebind(HELLO_BINDING_NAME, helloRMIServer);
            Naming.rebind(CALCULATOR_BINDING_NAME, calculatorRMIServer);
            Naming.rebind(PRODUCT_BINDING_NAME, productRMIServer);
            Naming.rebind(CHAT_BINDING_NAME, chatRMIServer);

            var message = String.format("RMIServers instances listening on port %d...", PORT);
            System.out.println(message);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
