package org.pniewiarowski.rmi.server.definition;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatRMIServerInterface extends Remote {
    /**
     * Registers a client with the server by specifying a name.
     *
     * @param name the name of the client to be registered
     *
     * @throws RemoteException if a communication error occurs during registration
     */
    public void register(String name) throws RemoteException;

    /**
     * Receives a message from a client.
     *
     * @param message the message to be received by the server
     *
     * @throws RemoteException if a communication error occurs during message reception
     */
    public void receiveMessage(String message) throws RemoteException;
}
