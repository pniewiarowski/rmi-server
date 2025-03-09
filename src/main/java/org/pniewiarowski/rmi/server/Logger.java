package org.pniewiarowski.rmi.server;

import org.pniewiarowski.rmi.server.definition.LoggerInterface;

public class Logger implements LoggerInterface {
    @Override
    public void info(String message) {
        System.out.println(message);
    }
}
