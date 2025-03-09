package org.pniewiarowski.rmi.server.server;

import org.pniewiarowski.rmi.logger.definition.LoggerInterface;
import org.pniewiarowski.rmi.server.definition.ChatRMIServerInterface;
import org.pniewiarowski.rmi.time.definition.LocalTimeInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatRMIServer extends UnicastRemoteObject implements ChatRMIServerInterface {
    private final LocalTimeInterface localTime;
    private final LoggerInterface logger;

    public ChatRMIServer(LocalTimeInterface localTime, LoggerInterface logger) throws RemoteException {
        super();

        this.localTime = localTime;
        this.logger = logger;
    }

    @Override
    public void register(String name) throws RemoteException {
        var time = localTime.get();
        var info = String.format("ChatRMIServer.register() called %s%n", time);

        logger.info(info);
    }

    @Override
    public void receiveMessage(String message) throws RemoteException {
        var time = localTime.get();
        var info = String.format("ChatRMIServer.register(int ID) called %s%n", time);

        logger.info(info);
    }
}
