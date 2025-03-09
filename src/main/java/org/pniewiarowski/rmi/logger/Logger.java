package org.pniewiarowski.rmi.logger;

import org.pniewiarowski.rmi.logger.definition.LoggerInterface;

public class Logger implements LoggerInterface {
    @Override
    public void info(String message) {
        System.out.println(message);
    }
}
