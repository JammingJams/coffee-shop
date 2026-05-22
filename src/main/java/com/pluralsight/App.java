package com.pluralsight;

import com.pluralsight.Model.Drinks.Coffee;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        double price = 0;
        String nameOfProduct = "Coffee";
        int servingSize = 1;
        int quantity = 1;
        int waterToDrinkRation = 2;

        if (nameOfProduct.equalsIgnoreCase("Coffee")) {
            if (servingSize == 1) {
                price = 6.50;
            }
            else if (servingSize == 2) {
                price = 9.50;
            }
            else if (servingSize == 3) {
                price = 11.00;
            }
        }

        if (waterToDrinkRation == 1) {
            price += 0.25;
        }
        else if (waterToDrinkRation == 2) {
            price += 0.75;
        }
        else if (waterToDrinkRation == 3) {
            price += 1;
        }

        Coffee.Sweeteners sweetAddIn = Coffee.Sweeteners.HONEY;
        ArrayList<Integer> amountOfAddIn = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));

        //We should do a for loop that would print out the sweetener ONLY if the amount is above 0

        int c = 1;

        switch (sweetAddIn) {
            case SUGAR -> {
                //This would add 1 to sugar amount for Now we will have four separate variables ALSO since this doesn't
                // add we don't have to worry about removing too much
                price += 0.25;
                amountOfAddIn.set(0,c);
                c++;

            }
            case HONEY -> {
                price += 0.75;
                amountOfAddIn.set(1,c);
                c++;
            }
        }

        for (Coffee.Sweeteners s : Coffee.Sweeteners.values()) {
            System.out.println(s);
        }


        Coffee coffee = new Coffee("Coffee",price,"S",quantity,waterToDrinkRation);



    }
}
