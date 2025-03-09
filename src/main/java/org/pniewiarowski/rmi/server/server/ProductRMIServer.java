package org.pniewiarowski.rmi.server.server;

import org.pniewiarowski.rmi.product.ProductMock;
import org.pniewiarowski.rmi.product.ProductModel;
import org.pniewiarowski.rmi.server.definition.LocalTimeInterface;
import org.pniewiarowski.rmi.server.definition.LoggerInterface;
import org.pniewiarowski.rmi.server.definition.server.ProductRMIServerInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ProductRMIServer extends UnicastRemoteObject implements ProductRMIServerInterface {
    private final LocalTimeInterface localTime;
    private final LoggerInterface logger;

    public ProductRMIServer(LocalTimeInterface localTime, LoggerInterface logger) throws RemoteException {
        super();

        this.localTime = localTime;
        this.logger = logger;
    }

    @Override
    public List<ProductModel> findAllProducts() throws RemoteException {
        var time = localTime.get();
        var info = String.format("ProductRMIServer.findAllProducts() called %s%n", time);

        logger.info(info);

        return ProductMock.get();
    }

    @Override
    public ProductModel findProductByID(int ID) throws RemoteException {
        var time = localTime.get();
        var info = String.format("ProductRMIServer.findProductByID(int ID) called %s%n", time);

        logger.info(info);

        return ProductMock.getByID(ID);
    }
}
