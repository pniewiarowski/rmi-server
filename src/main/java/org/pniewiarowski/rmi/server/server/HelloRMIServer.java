package org.pniewiarowski.rmi.server.server;

import org.pniewiarowski.rmi.logger.definition.LoggerInterface;
import org.pniewiarowski.rmi.server.definition.HelloRMIServerInterface;
import org.pniewiarowski.rmi.time.definition.LocalTimeInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloRMIServer extends UnicastRemoteObject implements HelloRMIServerInterface {
    private final LocalTimeInterface localTime;
    private final LoggerInterface logger;

    public HelloRMIServer(LocalTimeInterface timeLogger, LoggerInterface logger) throws RemoteException {
        super();

        this.localTime = timeLogger;
        this.logger = logger;
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        var time = localTime.get();
        var info = String.format("HelloRMIServer.sayHello(String name) called %s%n", time);

        logger.info(info);

        return String.format("Hello %s!", name);
    }


}
