package com.pluralsight.Model.Drinks;

import com.pluralsight.Interface.AddRemoveExtras;
import com.pluralsight.Model.Product;
import com.pluralsight.Model.Drinks.AddIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Coffee extends Product implements AddIn{
    private int waterToDrinkRatio;
    private Map<AddIn, Integer> addIns;

    public Coffee(String name, double price, String servingSize, int quantity, int waterToDrinkRatio) {
        super(name, price, servingSize, quantity);
        this.waterToDrinkRatio = waterToDrinkRatio;
        this.addIns = new HashMap<>();
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

    public void addAddIn(AddIn a, Coffee coffee) {
        this.addIns.put(a, addIns.getOrDefault(a,0) + 1);

        if (a instanceof Sweeteners)
            ((Sweeteners) a).add(getServingSize(), coffee);
        else if (a instanceof Flavorings)
            ((Flavorings) a).add(getServingSize(), coffee);
        else if (a instanceof Creamers)
            ((Creamers) a).add(getServingSize(), coffee);
        else if (a instanceof Spices)
            ((Spices) a).add(getServingSize(), coffee);
        else if (a instanceof DessertStyle)
            ((DessertStyle) a).add(getServingSize(), coffee);

    }

    public void removeAddIn(AddIn a, Coffee coffee) {
        if (!addIns.containsKey(a)) {return;}

        int amountOfAddIn = addIns.get(a);

        if (amountOfAddIn > 0) {
            addIns.remove(a);
        }
        else {
            System.out.println("INVALID can't remove 0 from list");
            return;
        }

        if (a instanceof Sweeteners)
            ((Sweeteners) a).add(getServingSize(), coffee);
        else if (a instanceof Flavorings)
            ((Flavorings) a).add(getServingSize(), coffee);
        else if (a instanceof Creamers)
            ((Creamers) a).add(getServingSize(), coffee);
        else if (a instanceof Spices)
            ((Spices) a).add(getServingSize(), coffee);
        else if (a instanceof DessertStyle)
            ((DessertStyle) a).add(getServingSize(), coffee);

    }

    public enum CoffeeType {
        CAPPUCCINO, LATTE, ESPRESSO, AMERICANO, MOCHA
    }

}
