package com.pluralsight.Model.Drinks;

import com.pluralsight.Model.Product;

import java.util.HashMap;
import java.util.Map;

public class Tea extends Product {
    private int waterToDrinkRatio;
    private Map<AddIn, Integer> addIns;

    public Tea(String name, double price, String servingSize, int quantity, int waterToDrinkRatio) {
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

    public void addAddIn(AddIn a, Tea tea) {
        this.addIns.put(a, addIns.getOrDefault(a,0) + 1);

        if (a instanceof AddIn.Sweeteners)
            ((AddIn.Sweeteners) a).add(getServingSize(), tea);
        else if (a instanceof AddIn.Flavorings)
            ((AddIn.Flavorings) a).add(getServingSize(), tea);
        else if (a instanceof AddIn.Creamers)
            ((AddIn.Creamers) a).add(getServingSize(), tea);
        else if (a instanceof AddIn.Spices)
            ((AddIn.Spices) a).add(getServingSize(), tea);
        else if (a instanceof AddIn.DessertStyle)
            ((AddIn.DessertStyle) a).add(getServingSize(), tea);

    }

    public void removeAddIn(AddIn a, Tea tea) {
        if (!addIns.containsKey(a)) {return;}

        int amountOfAddIn = addIns.get(a);

        if (amountOfAddIn > 0) {
            addIns.remove(a);
        }
        else {
            System.out.println("INVALID can't remove 0 from list");
            return;
        }

        if (a instanceof AddIn.Sweeteners)
            ((AddIn.Sweeteners) a).remove(getServingSize(), tea);
        else if (a instanceof AddIn.Flavorings)
            ((AddIn.Flavorings) a).remove(getServingSize(), tea);
        else if (a instanceof AddIn.Creamers)
            ((AddIn.Creamers) a).remove(getServingSize(), tea);
        else if (a instanceof AddIn.Spices)
            ((AddIn.Spices) a).remove(getServingSize(), tea);
        else if (a instanceof AddIn.DessertStyle)
            ((AddIn.DessertStyle) a).remove(getServingSize(), tea);

    }

    public enum CoffeeType {
        CAPPUCCINO, LATTE, ESPRESSO, AMERICANO, MOCHA
    }

}
