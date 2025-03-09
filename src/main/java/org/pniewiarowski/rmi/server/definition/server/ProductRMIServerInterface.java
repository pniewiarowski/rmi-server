package org.pniewiarowski.rmi.server.definition.server;

import org.pniewiarowski.rmi.product.ProductModel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ProductRMIServerInterface extends Remote {
    /**
     * Retrieves all products from the remote service.
     *
     * @return A list of all products
     * @throws RemoteException If there is an issue with the remote communication.
     */
    public List<ProductModel> findAllProducts() throws RemoteException;

    /**
     * Retrieves a product by his ID.
     *
     * @param ID The ID of the product to retrieve.
     *
     * @return The product with the specified ID.
     * @throws RemoteException If there is an issue with the remote communication.
     */
    public ProductModel findProductByID(int ID) throws RemoteException;
}
