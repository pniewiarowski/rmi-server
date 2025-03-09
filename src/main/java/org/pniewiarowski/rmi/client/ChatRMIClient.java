package org.pniewiarowski.rmi.client;

import org.pniewiarowski.rmi.server.definition.ChatRMIServerInterface;

import java.rmi.Naming;

public class ChatRMIClient {
    private final static String BINDING_NAME = "//localhost/ChatRMIServer";

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");

            var calculatorRMIRemote = (ChatRMIServerInterface) Naming.lookup(BINDING_NAME);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
