package org.pniewiarowski.rmi.server.definition;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloRMIServerInterface extends Remote {
    /**
     * Greets the user with a personalized hello message.
     *
     * @param name The name of the person to greet.
     *
     * @return A greeting message that includes the provided name.
     * @throws RemoteException If there is an issue with the remote communication.
     */
    public String sayHello(String name) throws RemoteException;
}
