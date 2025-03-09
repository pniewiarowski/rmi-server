package org.pniewiarowski.rmi.client;

import org.pniewiarowski.rmi.server.definition.ProductRMIServerInterface;

import java.rmi.Naming;

public class ProductRMIClient {
    private final static String BINDING_NAME = "//localhost/ProductRMIServer";

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");

            var productRMIRemote = (ProductRMIServerInterface) Naming.lookup(BINDING_NAME);
            var getCollectionOfProductsResult = productRMIRemote.findAllProducts();
            var getProductByIDResult = productRMIRemote.findProductByID(3);

            System.out.printf("Response RMIServerInterface.getCollectionOfProducts(): %s%n", getCollectionOfProductsResult);
            System.out.printf("Response RMIServerInterface.getProductByID(3): %s%n", getProductByIDResult);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
