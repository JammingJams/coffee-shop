package com.pluralsight;

import com.pluralsight.Model.BreakfastMeals.BakedGoods;
import com.pluralsight.Model.BreakfastMeals.BreakfastSandwiches;
import com.pluralsight.Model.BreakfastMeals.MeatTypes;
import com.pluralsight.Model.Drinks.Coffee;
import com.pluralsight.Model.Drinks.Coffee.CoffeeType;
import com.pluralsight.Interface.AddIn;
import com.pluralsight.Model.Drinks.Tea;
import com.pluralsight.Model.Product;
import com.pluralsight.Model.ShoppingCart;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        double price = 0;
        String nameOfProduct = "Coffee";
        int servingSize = 1;
        int quantity = 1;
        int waterToDrinkRation = 2;


        if (waterToDrinkRation == 1) {
            price += 0.25;
        }
        else if (waterToDrinkRation == 2) {
            price += 0.75;
        }
        else if (waterToDrinkRation == 3) {
            price += 1;
        }

        //Coffee.Sweeteners sweetAddIn = Coffee.Sweeteners.HONEY;
        AddIn.Sweeteners sweetAddIn = AddIn.Sweeteners.HONEY;


        Coffee americano = new Coffee("Coffee",price,"Small",quantity);

        americano.setCoffeeType(CoffeeType.AMERICANO);

        americano.add(AddIn.Sweeteners.HONEY);
        americano.add(AddIn.Sweeteners.HONEY);
        americano.add(AddIn.Sweeteners.SUGAR);

        Coffee mocha = new Coffee("Coffee",price,"Medium",quantity);

        mocha.setCoffeeType(CoffeeType.MOCHA);

        mocha.add(AddIn.Sweeteners.HONEY);
        mocha.add(AddIn.Sweeteners.HONEY);
        mocha.add(AddIn.Sweeteners.SUGAR);

        Tea ube = new Tea("Tea",0,"Large", 1);

        ube.setTeaType(Tea.TeaType.UBE);

        ube.add(AddIn.Flavorings.CHOCOLATESHAVINGS);
        ube.add(AddIn.DessertStyle.BROWNIE);
        ube.add(AddIn.Spices.CINNAMON);

        ube.getAddIns().forEach((key, value) -> System.out.println("Type: " + key + " Amount: " + value));

        cart.add(americano);
        cart.add(ube);
        cart.add(mocha);

        cart.getCart().stream().filter(p -> p instanceof Coffee).forEach(c ->
                ((Coffee) c).getAddIns().forEach((key, value) -> System.out.println("Type: " + key + " Amount: " + value)));

        for (int i = 0; i < 5; i++) {
            Tea tea = new Tea("Tea",0,"Large",1);

            tea.setTeaType(Tea.TeaType.BOBA);

            tea.add(AddIn.Spices.CINNAMON);
            tea.add(AddIn.Spices.CARDAMOM);
            tea.add(AddIn.Sweeteners.SYRUP);
            tea.add(AddIn.Spices.NUTMEG);

            cart.add(tea);
        }

        BreakfastSandwiches grilledChees = new BreakfastSandwiches("Breakfast Sandwich", 0, "Medium", 1);

        grilledChees.setBreakfastSandwich(BreakfastSandwiches.SandwichTypes.BREAKFASTGRILLEDCHEESE);

        grilledChees.remove(MeatTypes.BACON);

        grilledChees.add(MeatTypes.BACON);
        grilledChees.add(MeatTypes.BACON);
        grilledChees.add(MeatTypes.BACON);
        grilledChees.add(MeatTypes.BACON);
        grilledChees.add(MeatTypes.BACON);
        grilledChees.add(MeatTypes.SAUSAGE);
        grilledChees.add(MeatTypes.EGG);
        grilledChees.add(MeatTypes.CHEESE);

        BakedGoods bagel = new BakedGoods("Baked Goods",0,"Large",1);

        bagel.setBakedGoods(BakedGoods.BakedGoodsType.BAGELS);
        bagel.remove(MeatTypes.SAUSAGE);
        bagel.add(MeatTypes.EGG);
        bagel.add(MeatTypes.EGG);

        System.out.println(grilledChees);

        cart.add(grilledChees);
        cart.add(bagel);

        cart.getCart().forEach(p -> System.out.println(p));





    }
}
