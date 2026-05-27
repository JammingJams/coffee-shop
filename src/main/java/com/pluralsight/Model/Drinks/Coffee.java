package com.pluralsight.Model.Drinks;

import com.pluralsight.Interface.AddRemoveExtras;
import com.pluralsight.Model.Product;
import com.pluralsight.Interface.AddIn;

import java.util.HashMap;
import java.util.Map;

public class Coffee extends Product implements AddIn, AddRemoveExtras{
    private int waterToDrinkRatio;
    private String coffeeTypeName;
    private Map<AddIn, Integer> addIns;

    public Coffee(String name, double price, String servingSize, int quantity) {
        super(name, price, servingSize, quantity);
        this.waterToDrinkRatio = waterToDrinkRatio;
        this.addIns = new HashMap<>();
        this.coffeeTypeName = "";
    }

    public int getWaterToDrinkRatio() {
        return waterToDrinkRatio;
    }

    public void setWaterToDrinkRatio(int waterToDrinkRatio) {
        this.waterToDrinkRatio = waterToDrinkRatio;
    }

    public Map<AddIn, Integer> getAddIns() {
        return addIns;
    }

    public String getCoffeeTypeName() {
        return coffeeTypeName;
    }

    public void setCoffeeTypeName(String coffeeTypeName) {
        this.coffeeTypeName = coffeeTypeName;
    }

    public void add(AddIn a) {
        this.addIns.put(a, addIns.getOrDefault(a,0) + 1);

        if (a instanceof Sweeteners)
            setPrice(getPrice() + getPriceForSize(getServingSize(), ((Sweeteners) a).getLargeMediumSmallPrice()));
        else if (a instanceof Flavorings)
            setPrice(getPrice() + getPriceForSize(getServingSize(), ((Flavorings) a).getLargeMediumSmallPrice()));
        else if (a instanceof Creamers)
            setPrice(getPrice() + getPriceForSize(getServingSize(), ((Creamers) a).getLargeMediumSmallPrice()));
        else if (a instanceof Spices)
            setPrice(getPrice() + getPriceForSize(getServingSize(), ((Spices) a).getLargeMediumSmallPrice()));
        else if (a instanceof DessertStyle)
            setPrice(getPrice() + getPriceForSize(getServingSize(), ((DessertStyle) a).getLargeMediumSmallPrice()));

    }

    public void remove(AddIn a) {
        if (!addIns.containsKey(a)) {
            System.out.println("INVALID can't remove 0 from list");
            return;
        }

        int amountOfAddIn = addIns.get(a);


        if (amountOfAddIn > 0) {
            this.addIns.put(a, addIns.getOrDefault(a,0) - 1);
            if (addIns.get(a) == 0) {
                addIns.remove(a);
            }
        }
        else {
            System.out.println("INVALID can't remove 0 from list");
            return;
        }

        if (a instanceof Sweeteners)
            setPrice(getPrice() - getPriceForSize(getServingSize(), ((Sweeteners) a).getLargeMediumSmallPrice()));
        else if (a instanceof Flavorings)
            setPrice(getPrice() - getPriceForSize(getServingSize(), ((Flavorings) a).getLargeMediumSmallPrice()));
        else if (a instanceof Creamers)
            setPrice(getPrice() - getPriceForSize(getServingSize(), ((Creamers) a).getLargeMediumSmallPrice()));
        else if (a instanceof Spices)
            setPrice(getPrice() - getPriceForSize(getServingSize(), ((Spices) a).getLargeMediumSmallPrice()));
        else if (a instanceof DessertStyle)
            setPrice(getPrice() - getPriceForSize(getServingSize(), ((DessertStyle) a).getLargeMediumSmallPrice()));

    }

    //This sets the price for and name for the coffee
    // double[] smallMediumLargePrice
    public void setCoffeeType(CoffeeType c) {
        if (c.getLabel().equalsIgnoreCase("Cappuccino")) {
            setCoffeeTypeName("Cappuccino");
            setPrice(c.getPrice() + getPriceForSize(getServingSize(), c.getSmallMediumLargePrice()));
        }
        else if (c.getLabel().equalsIgnoreCase("Latte")) {
            setCoffeeTypeName("Latte");
            setPrice(c.getPrice() + getPriceForSize(getServingSize(), c.getSmallMediumLargePrice()));
        }
        else if (c.getLabel().equalsIgnoreCase("Espresso")) {
            setCoffeeTypeName("Espresso");
            setPrice(c.getPrice() + getPriceForSize(getServingSize(), c.getSmallMediumLargePrice()));
        }
        else if (c.getLabel().equalsIgnoreCase("Americano")) {
            setCoffeeTypeName("Americano");
            setPrice(c.getPrice() + getPriceForSize(getServingSize(), c.getSmallMediumLargePrice()));
        }
        else if (c.getLabel().equalsIgnoreCase("Mocha")) {
            setCoffeeTypeName("Mocha");
            setPrice(c.getPrice() + getPriceForSize(getServingSize(), c.getSmallMediumLargePrice()));
        }


    }

    @Override
    public String toString() {
        String amountOfAddIn = "";

        if (getAddIns() == null) {
            return String.format("%s|%s|%.2f|%s|x%d", getName(), getCoffeeTypeName(), getPrice(), getServingSize(), getQuantity());
        }

        for (AddIn a : getAddIns().keySet()) {
            amountOfAddIn += a + "|x" + getAddIns().get(a) + "|";
        }

        int index = amountOfAddIn.lastIndexOf("|");

        if (index == -1) {
            return String.format("%s|%s|%.2f|%s|x%d", getName(), getCoffeeTypeName(), getPrice(), getServingSize(), getQuantity());
        }

        amountOfAddIn = amountOfAddIn.substring(0, index) + "" + amountOfAddIn.substring(index + 1);
        return String.format("%s|%s|%.2f|%s|x%d|%s",
                getName(), getCoffeeTypeName(), getPrice(), getServingSize(), getQuantity(), amountOfAddIn);
    }

    //This enum is a constructor for our Coffee it allows us to expand and update our stock and prices
    public enum CoffeeType {
        CAPPUCCINO("Cappuccino", 6.5), LATTE("Latte", 6.5), ESPRESSO("Espresso", 6.5),
        AMERICANO("Americano", 6.5), MOCHA("Mocha", 6.5);

        private final String label;
        private final double price;
        private final double[] smallMediumLargePrice = {0, 3, 4.5};

        CoffeeType(String label, double price) {
            this.label = label;
            this.price = price;
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


        @Override
        public String toString() {
            return label;
        }
    }

}
