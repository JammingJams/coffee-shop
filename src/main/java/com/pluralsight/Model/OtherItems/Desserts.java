package com.pluralsight.Model.OtherItems;

import com.pluralsight.Model.Product;

public class Desserts extends Product {
    private String dessertsName;

    public Desserts(String name, double price, String servingSize, int quantity) {
        super(name, price, servingSize, quantity);
        this.dessertsName = "";
    }

    public String getDessertsName() {
        return dessertsName;
    }

    public void setDessertsName(String sandwichName) {
        this.dessertsName = sandwichName;
    }

    //This sets the price for and name for the coffee
    public void setDesserts(DessertType d) {
        if (d == DessertType.PUMPKINPIE) {
            setDessertsName("Pumpkin Pie");
            setPrice(d.getPrice() + getPriceForSize(getServingSize(), d.getSmallMediumLargePrice()));
        }
        else if (d == DessertType.COFFEECAKE) {
            setDessertsName("Coffee Cake");
            setPrice(d.getPrice() + getPriceForSize(getServingSize(), d.getSmallMediumLargePrice()));
        }
        else if (d == DessertType.CUPCAKE) {
            setDessertsName("Cupcake");
            setPrice(d.getPrice() + getPriceForSize(getServingSize(), d.getSmallMediumLargePrice()));
        }
        else if (d == DessertType.ICECREAM) {
            setDessertsName("Ice Cream");
            setPrice(d.getPrice() + getPriceForSize(getServingSize(), d.getSmallMediumLargePrice()));
        }

    }

    @Override
    public String toString() {
        return String.format("%s|%s|%.2f|%s|x%d",
                getName(), getDessertsName(), getPrice(), getServingSize(), getQuantity());
    }

    public enum DessertType {
        COFFEECAKE("Coffee Cake", 7.5), ICECREAM("Ice Cream", 4.5),
        PUMPKINPIE("Pumpkin Pie", 7),
        CUPCAKE("Cupcake", 3.5);

        private final String label;
        private final double price;
        private double[] smallMediumLargePrice = {0, 2, 4.5};

        DessertType(String label, double price) {
            this.label = label;
            this.price = price;
            this.smallMediumLargePrice = smallMediumLargePrice;
        }

        public String getLabel() {
            return label;
        }

        public double getPrice() {
            return price;
        }

        public double[] getSmallMediumLargePrice() {
            return smallMediumLargePrice;
        }

        public void setSmallMediumLargePrice(double[] smallMediumLargePrice) {
            this.smallMediumLargePrice = smallMediumLargePrice;
        }

        @Override
        public String toString() {
            return label;
        }

    }

    public double getPriceForSize(String servingSize, double[] variablePrice) {
        return switch (servingSize) {
            case "Large" -> variablePrice[2];
            case "Medium" -> variablePrice[1];
            case "Small" -> variablePrice[0];
            default -> 0;
        };
    }
}
