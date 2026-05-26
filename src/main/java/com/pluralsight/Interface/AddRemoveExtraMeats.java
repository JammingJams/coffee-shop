package com.pluralsight.Interface;

import com.pluralsight.Model.BreakfastMeals.MeatTypes;

public interface AddRemoveExtraMeats {
    void add(MeatTypes a);
    void remove(MeatTypes a);
    default double getPriceForSize(String servingSize, double[] variablePrice) {
        return switch (servingSize) {
            case "Large" -> variablePrice[2];
            case "Medium" -> variablePrice[1];
            case "Small" -> variablePrice[0];
            default -> 0;
        };
    }
    default boolean isAmountOfExtrasBelow1(int amountOfAddIn) {
        if (amountOfAddIn <= 0) {
            System.out.println("INVALID LENGTH can't remove 0");
            return true;
        }
        return false;
    }
}
