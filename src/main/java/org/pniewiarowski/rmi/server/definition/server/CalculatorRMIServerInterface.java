package org.pniewiarowski.rmi.server.definition.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorRMIServerInterface extends Remote {
    /**
     * Adds the given values together.
     *
     * @param values The values to be added.
     *
     * @return The sum of the given values.
     * @throws RemoteException If there is an issue with the remote communication.
     */
    public float addition(float... values) throws RemoteException;

    /**
     * Subtracts all the given values from the specified base value.
     *
     * @param base The value from which all other values will be subtracted.
     * @param values The values to be subtracted from the base.
     *
     * @return The result of the subtraction.
     * @throws RemoteException If there is an issue with the remote communication.
     */
    public float subtract(float base, float... values) throws RemoteException;

    /**
     * Multiplies the given values together.
     *
     * @param values The values to be multiplied.
     *
     * @return The product of the given values.
     * @throws RemoteException If there is an issue with the remote communication.
     */
    public float multiply(float... values) throws RemoteException;

    /**
     * Divides the first value by the subsequent values.
     *
     * @param base The value to be divided.
     * @param values The values to divide the first value by.
     *
     * @return The result of the division.
     * @throws ArithmeticException If division by zero is attempted.
     * @throws RemoteException If there is an issue with the remote communication.
     */
    public float divide(float base, float... values) throws RemoteException, ArithmeticException;

}
