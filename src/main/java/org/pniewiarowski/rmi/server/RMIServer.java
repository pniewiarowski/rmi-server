package org.pniewiarowski.rmi.server;

import org.pniewiarowski.rmi.calculator.definition.CalculatorInterface;
import org.pniewiarowski.rmi.server.definition.LoggerInterface;
import org.pniewiarowski.rmi.server.definition.RMIServerInterface;
import org.pniewiarowski.rmi.server.definition.LocalTimeInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer extends UnicastRemoteObject implements RMIServerInterface {
    private final CalculatorInterface calculator;
    private final LocalTimeInterface localTime;
    private final LoggerInterface logger;

    protected RMIServer(
            CalculatorInterface calculator,
            LocalTimeInterface timeLogger,
            LoggerInterface logger
    ) throws RemoteException {
        super();

        this.calculator = calculator;
        this.localTime = timeLogger;
        this.logger = logger;
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        var time = localTime.get();
        var info = String.format("RMIServer.sayHello(String name) called %s%n", time);

        logger.info(info);

        return String.format("Hello %s!", name);
    }

    @Override
    public float addition(float... values) throws RemoteException {
        var time = localTime.get();
        var info = String.format("RMIServer.addition(float... values) called %s%n", time);

        logger.info(info);

        return calculator.addition(values);
    }

    @Override
    public float subtract(float base, float... values) throws RemoteException {
        var time = localTime.get();
        var info = String.format("RMIServer.subtract(float base, float... values) called %s%n", time);

        logger.info(info);

        return calculator.subtract(base, values);
    }

    @Override
    public float multiply(float... values) throws RemoteException {
        var time = localTime.get();
        var info = String.format("RMIServer.multiply(float... values) called %s%n", time);

        logger.info(info);

        return calculator.multiply(values);
    }

    @Override
    public float divide(float base, float... values) throws RemoteException, ArithmeticException {
        var time = localTime.get();
        var info = String.format("RMIServer.multiply(float... values) called %s%n", time);

        logger.info(info);

        return calculator.divide(base, values);
    }
}
