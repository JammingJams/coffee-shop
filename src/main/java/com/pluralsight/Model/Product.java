package com.pluralsight.Model;

public abstract class Product {
    protected String name, servingSize;
    protected double price;
    protected int quantity;

    public Product(String name, double price, String servingSize, int quantity) {
        this.name = name;
        this.price = price;
        this.servingSize = servingSize;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
