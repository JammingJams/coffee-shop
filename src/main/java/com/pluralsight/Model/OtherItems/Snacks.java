package com.pluralsight.Model.OtherItems;

import com.pluralsight.Model.Product;

public class Snacks extends Product {
    private String snacksName;

    public Snacks(String name, double price, String servingSize, int quantity) {
        super(name, price, servingSize, quantity);
        this.snacksName = "";
    }

    public String getSnacksName() {
        return snacksName;
    }

    public void setSnacksName(String sandwichName) {
        this.snacksName = sandwichName;
    }

    //This sets the price for and name for the coffee
    public void setSnackType(SnackType s) {
        if (s == SnackType.CHEETOS) {
            setSnacksName("Cheetos");
            setPrice(s.getPrice() + getPriceForSize(getServingSize(), s.getSmallMediumLargePrice()));
        }
        else if (s == SnackType.DORITOS) {
            setSnacksName("Doritos");
            setPrice(s.getPrice() + getPriceForSize(getServingSize(), s.getSmallMediumLargePrice()));
        }
        else if (s == SnackType.PEANUTS) {
            setSnacksName("Peanuts");
            setPrice(s.getPrice() + getPriceForSize(getServingSize(), s.getSmallMediumLargePrice()));
        }
        else if (s == SnackType.HEALTHBARS) {
            setSnacksName("Health Bars");
            setPrice(s.getPrice() + getPriceForSize(getServingSize(), s.getSmallMediumLargePrice()));
        }

    }

    @Override
    public String toString() {
        return String.format("%s|%s|%.2f|%s|x%d",
                getName(), getSnacksName(), getPrice(), getServingSize(), getQuantity());
    }

    public enum SnackType {
        PEANUTS("Peanuts", 0.5), CHEETOS("Cheetos", 0.5),
        DORITOS("Doritos", 0.5),
        HEALTHBARS("Health Bars", 1);

        private final String label;
        private final double price;
        private double[] smallMediumLargePrice = {0, 0.75, 2};

        SnackType(String label, double price) {
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
