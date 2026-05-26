package com.pluralsight.Model;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void add(Product p) {
        this.cart.add(p);
    }

    public void remove(Product p) {
        this.cart.remove(p);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
