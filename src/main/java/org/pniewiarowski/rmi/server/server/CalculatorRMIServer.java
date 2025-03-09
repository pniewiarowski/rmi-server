package org.pniewiarowski.rmi.server.server;

import org.pniewiarowski.rmi.calculator.definition.CalculatorInterface;
import org.pniewiarowski.rmi.server.definition.LocalTimeInterface;
import org.pniewiarowski.rmi.server.definition.LoggerInterface;
import org.pniewiarowski.rmi.server.definition.server.CalculatorRMIServerInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorRMIServer extends UnicastRemoteObject implements CalculatorRMIServerInterface {
    private final LocalTimeInterface localTime;
    private final LoggerInterface logger;
    private final CalculatorInterface calculator;

    public CalculatorRMIServer(LocalTimeInterface localTime, LoggerInterface logger, CalculatorInterface calculator) throws RemoteException {
        super();

        this.localTime = localTime;
        this.logger = logger;
        this.calculator = calculator;
    }

    @Override
    public float addition(float... values) throws RemoteException {
        var time = localTime.get();
        var info = String.format("CalculatorRMIServer.addition(float... values) called %s%n", time);

        logger.info(info);

        return calculator.addition(values);
    }

    @Override
    public float subtract(float base, float... values) throws RemoteException {
        var time = localTime.get();
        var info = String.format("CalculatorRMIServer.subtract(float base, float... values) called %s%n", time);

        logger.info(info);

        return calculator.subtract(base, values);
    }

    @Override
    public float multiply(float... values) throws RemoteException {
        var time = localTime.get();
        var info = String.format("CalculatorRMIServer.multiply(float... values) called %s%n", time);

        logger.info(info);

        return calculator.multiply(values);
    }

    @Override
    public float divide(float base, float... values) throws RemoteException, ArithmeticException {
        var time = localTime.get();
        var info = String.format("CalculatorRMIServer.multiply(float... values) called %s%n", time);

        logger.info(info);

        return calculator.divide(base, values);
    }
}
