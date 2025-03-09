package org.pniewiarowski.rmi.product;

import java.util.ArrayList;
import java.util.List;

/**
 * A mock class to manage a collection of products.
 * This class provides methods to retrieve all products and find a product by its ID.
 */
public class ProductMock {
    private static final List<ProductModel> products = new ArrayList<ProductModel>();

    static {
        products.add(new ProductModel(1, "Test Product 001", 19.99f));
        products.add(new ProductModel(2, "Test Product 002", 49.99f));
        products.add(new ProductModel(3, "Test Product 003", 19.99f));
        products.add(new ProductModel(4, "Test Product 004", 29.99f));
        products.add(new ProductModel(5, "Test Product 005", 49.99f));
    }

    public static List<ProductModel> get() {
        return products;
    }

    public static ProductModel getByID(int ID) {
        for (ProductModel product : products) {
            if (product.ID == ID) {
                return product;
            }
        }

        return null;
    }
}
