package org.pniewiarowski.rmi.product;

import java.io.Serializable;

public class ProductModel implements Serializable {
    public int ID;
    public String name;
    public float price;

    public ProductModel(int ID, String name, float price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product [ID=%d, name=%s, price=%f]", ID, name, price);
    }
}
