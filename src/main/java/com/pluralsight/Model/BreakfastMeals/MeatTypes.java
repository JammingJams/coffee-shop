package com.pluralsight.Model.BreakfastMeals;

public enum MeatTypes {
    SAUSAGE("Sausage", 1), CHEESE("Cheese", 1.25), EGG("Egg", 1.5), BACON("Bacon", 2);

    private final String label;
    private final double price;
    private final double[] breakfastMeatPrice = {0, 1.5};

    MeatTypes(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }

    public double[] getBreakfastMeatPrice() {
        return breakfastMeatPrice;
    }

    @Override
    public String toString() {
        return label;
    }
}
