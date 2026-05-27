package com.pluralsight.View;

import com.pluralsight.Controller.InventoryLogger;
import com.pluralsight.Interface.AddIn;
import com.pluralsight.Model.BreakfastMeals.BakedGoods;
import com.pluralsight.Model.BreakfastMeals.BreakfastSandwiches;
import com.pluralsight.Model.BreakfastMeals.MeatTypes;
import com.pluralsight.Model.Drinks.Coffee;
import com.pluralsight.Model.Drinks.Tea;
import com.pluralsight.Model.OtherItems.Desserts;
import com.pluralsight.Model.OtherItems.Snacks;
import com.pluralsight.Model.Product;
import com.pluralsight.Model.ShoppingCart;
import com.pluralsight.Model.SpecialityItems.SpecialCoffee;

import java.util.Scanner;

public class MainMenu {
    public static Scanner sc = new Scanner(System.in);
    public static ShoppingCart shoppingCart = new ShoppingCart();

    public static void runApp() {
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Home Screen -----====");
            System.out.print("(1) -> New Order\n" +
                    "(2) -> Exit\n" +
                    "Answer Here: ");
            switch (sc.nextLine().trim()) {
                case "1" -> newOrderProcess();
                case "2" -> isUserInMenu = false;
                default -> System.out.println("Invalid user input!");
            }
        }
        System.out.println("Have a good day");

    }

    public static void newOrderProcess() {
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Order Screen -----====");
            System.out.print("(1) -> Add Drink\n" +
                    "(2) -> Add Side Item\n" +
                    "(3) -> Add Other Item\n" +
                    "(4) -> Add Speciality Item\n" +
                    "(5) -> View Cart\n" +
                    "(6) -> Check Out\n" +
                    "(7) -> Cancel Order\n" +
                    "(8) -> Exit Back to Home\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> addDrinkProcess();
                case "2" -> addSideItemsProcess();
                case "3" -> addOtherItemsProcess();
                case "4" -> addSpecialityItemProcess();
                case "5" -> viewCartProcess();
                case "6" -> checkOutProcess();
                case "7" -> cancelOrderProcess();
                case "8" -> isUserInMenu = false;
                default -> System.out.println("Invalid user input!");
            }
        }
    }

    public static void addDrinkProcess() {
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Drink Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            System.out.print("(1) -> Coffee\n" +
                    "(2) -> Tea\n" +
                    "(3) -> Exit to Order Screen\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> {
                    addCoffeeProcess();
                    isUserInMenu = false;
                }
                case "2" -> {
                    addTeaProcess();
                    isUserInMenu = false;
                }
                case "3" -> isUserInMenu = false;
                default -> System.out.println("Invalid user input!");
            }
        }
    }

    public static void addSideItemsProcess() {
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Breakfast Item Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            System.out.print("(1) -> Baked Goods\n" +
                    "(2) -> Breakfast Sandwiches\n" +
                    "(3) -> Exit to Order Screen\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> {
                    addBakedGoods();
                    isUserInMenu = false;
                }
                case "2" -> {
                    addBreakfastSandwiches();
                    isUserInMenu = false;
                }
                case "3" -> isUserInMenu = false;
                default -> System.out.println("Invalid user input!");
            }
        }
    }

    public static void addOtherItemsProcess() {
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Order Screen -----====");
            System.out.print("(1) -> Add Snacks\n" +
                    "(2) -> Add Desserts\n" +
                    "(3) -> Exit Back to Home\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> addSnacksProcess();
                case "2" -> addDessertsProcess();
                case "3" -> isUserInMenu = false;
                default -> System.out.println("Invalid user input!");
            }
        }

    }

    public static void addSpecialityItemProcess() {
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0,0,0};

        while (isUserInMenu) {
            boolean invalidInput = false;

            System.out.println("====----- Special Coffee Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            System.out.print("(1) -> Add Birthday Blitz\n" +
                    "(2) -> Add Carameltdown\n" +
                    "(3) -> Add Choco Mucho\n" +
                    "(4) -> Add Creamy's Delight\n" +
                    "(5) -> Add Spice My Ice\n" +
                    "(6) -> Exit Back to Home\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> userChoice = "Birthday Blitz";
                case "2" -> userChoice = "Carameltdown";
                case "3" -> userChoice = "Choco Mucho";
                case "4" -> userChoice = "Creamy's Delight";
                case "5" -> userChoice = "Spice My Ice";
                case "6" -> isUserInMenu = false;
                default -> {
                    System.out.println("Invalid user input!");
                    invalidInput = true;
                }
            }

            if (isUserInMenu&&!invalidInput) {

                SpecialCoffee coffee = new SpecialCoffee("SpecialCoffee", 0, "Small", 1);
                switch (userChoice.toLowerCase()) {
                    case "birthday blitz" -> {
                        coffee.setCoffeeType(SpecialCoffee.SpecialCoffeeType.BIRTHDAYBLITZ);
                        largeMediumSmallPrice = SpecialCoffee.SpecialCoffeeType.BIRTHDAYBLITZ.getSmallMediumLargePrice();
                        coffee.add(AddIn.DessertStyle.WHIPPEDCREAM);
                        coffee.add(AddIn.DessertStyle.ICECREAM);
                    }
                    case "carameltdown" -> {
                        coffee.setCoffeeType(SpecialCoffee.SpecialCoffeeType.CARAMELTDOWN);
                        largeMediumSmallPrice = SpecialCoffee.SpecialCoffeeType.CARAMELTDOWN.getSmallMediumLargePrice();
                        coffee.add(AddIn.Sweeteners.SYRUP);
                    }
                    case "choco mucho" -> {
                        coffee.setCoffeeType(SpecialCoffee.SpecialCoffeeType.CHOCOMUCHO);
                        largeMediumSmallPrice = SpecialCoffee.SpecialCoffeeType.CHOCOMUCHO.getSmallMediumLargePrice();
                        coffee.add(AddIn.DessertStyle.BROWNIE);
                        coffee.add(AddIn.Flavorings.COCOANIBS);
                        coffee.add(AddIn.Flavorings.CHOCOLATESHAVINGS);
                    }
                    case "creamy's delight" -> {
                        coffee.setCoffeeType(SpecialCoffee.SpecialCoffeeType.CREAMYSDELIGHT);
                        largeMediumSmallPrice = SpecialCoffee.SpecialCoffeeType.CREAMYSDELIGHT.getSmallMediumLargePrice();
                        coffee.add(AddIn.Creamers.OATMILK);
                        coffee.add(AddIn.Creamers.BUTTER);
                    }
                    case "spice my ice" -> {
                        coffee.setCoffeeType(SpecialCoffee.SpecialCoffeeType.SPICEMYICE);
                        largeMediumSmallPrice = SpecialCoffee.SpecialCoffeeType.SPICEMYICE.getSmallMediumLargePrice();
                        coffee.add(AddIn.Spices.NUTMEG);
                        coffee.add(AddIn.Spices.CAYENNEPEPPER);
                    }
                    default -> System.out.println("Coffee type does not exist");
                }
                size = sizeSelectionProcess(largeMediumSmallPrice, coffee.getPrice());
                coffee.setServingSize(size);
                coffee.setPrice(coffee.getPrice() + coffee.getPriceForSize(size, largeMediumSmallPrice));

                selectAddInProcess(coffee);

                shoppingCart.add(coffee);

                isUserInMenu = false;
            }


        }
    }

    public static void addCoffeeProcess() {
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0,0,0};

        while (isUserInMenu) {
            boolean invalidInput = false;

            System.out.println("====----- Coffee Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            System.out.print("(1) -> Add Cappuccino\n" +
                    "(2) -> Add Latte\n" +
                    "(3) -> Add Espresso\n" +
                    "(4) -> Add Americano\n" +
                    "(5) -> Add Mocha\n" +
                    "(6) -> Exit Back to Home\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> userChoice = "Cappuccino";
                case "2" -> userChoice = "Latte";
                case "3" -> userChoice = "Espresso";
                case "4" -> userChoice = "Americano";
                case "5" -> userChoice = "Mocha";
                case "6" -> isUserInMenu = false;
                default -> {
                    System.out.println("Invalid user input!");
                    invalidInput = true;
                }
            }

            if (isUserInMenu&&!invalidInput) {

                Coffee coffee = new Coffee("Coffee", 0, "Small", 1);
                switch (userChoice.toLowerCase()) {
                    case "cappuccino" -> {
                        coffee.setCoffeeType(Coffee.CoffeeType.CAPPUCCINO);
                        largeMediumSmallPrice = Coffee.CoffeeType.CAPPUCCINO.getSmallMediumLargePrice();
                    }
                    case "latte" -> {
                        coffee.setCoffeeType(Coffee.CoffeeType.LATTE);
                        largeMediumSmallPrice = Coffee.CoffeeType.LATTE.getSmallMediumLargePrice();
                    }
                    case "espresso" -> {
                        coffee.setCoffeeType(Coffee.CoffeeType.ESPRESSO);
                        largeMediumSmallPrice = Coffee.CoffeeType.ESPRESSO.getSmallMediumLargePrice();
                    }
                    case "americano" -> {
                        coffee.setCoffeeType(Coffee.CoffeeType.AMERICANO);
                        largeMediumSmallPrice = Coffee.CoffeeType.AMERICANO.getSmallMediumLargePrice();
                    }
                    case "mocha" -> {
                        coffee.setCoffeeType(Coffee.CoffeeType.MOCHA);
                        largeMediumSmallPrice = Coffee.CoffeeType.MOCHA.getSmallMediumLargePrice();
                    }
                    default -> System.out.println("Coffee type does not exist");
                }
                size = sizeSelectionProcess(largeMediumSmallPrice, coffee.getPrice());
                coffee.setServingSize(size);
                coffee.setPrice(coffee.getPrice() + coffee.getPriceForSize(size, largeMediumSmallPrice));

                selectAddInProcess(coffee);

                shoppingCart.add(coffee);

                isUserInMenu = false;
            }


        }
    }

    public static void addTeaProcess() {
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0,0,0};

        while (isUserInMenu) {
            boolean invalidInput = false;

            System.out.println("====----- Tea Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            System.out.print("(1) -> Add Ube\n" +
                    "(2) -> Add Green\n" +
                    "(3) -> Add Boba\n" +
                    "(4) -> Exit Back to Home\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> userChoice = "Ube";
                case "2" -> userChoice = "Green";
                case "3" -> userChoice = "Boba";
                case "4" -> isUserInMenu = false;
                default -> {
                    System.out.println("Invalid user input!");
                    invalidInput = true;
                }
            }

            if (isUserInMenu&&!invalidInput) {

                Tea coffee = new Tea("Tea", 0, size, 1);
                switch (userChoice.toLowerCase()) {
                    case "ube" -> {
                        coffee.setTeaType(Tea.TeaType.UBE);
                        largeMediumSmallPrice = Tea.TeaType.UBE.getSmallMediumLargePrices();
                    }
                    case "green" -> {
                        coffee.setTeaType(Tea.TeaType.GREEN);
                        largeMediumSmallPrice = Tea.TeaType.GREEN.getSmallMediumLargePrices();
                    }
                    case "boba" -> {
                        coffee.setTeaType(Tea.TeaType.BOBA);
                        largeMediumSmallPrice = Tea.TeaType.BOBA.getSmallMediumLargePrices();
                    }
                    default -> System.out.println("Tea type does not exist");
                }

                size = sizeSelectionProcess(largeMediumSmallPrice, coffee.getPrice());
                coffee.setServingSize(size);
                coffee.setPrice(coffee.getPrice() + coffee.getPriceForSize(size, largeMediumSmallPrice));
                selectAddInProcess(coffee);

                shoppingCart.add(coffee);
                isUserInMenu = false;
            }

        }
    }

    public static void addBreakfastSandwiches() {
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0,0,0};

        while (isUserInMenu) {
            boolean invalidInput = false;

            System.out.println("====----- Tea Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            System.out.print("(1) -> Add Bacon, Egg, & Cheese Sandwich\n" +
                    "(2) -> Add Sausage, Egg, & Cheese Sandwich\n" +
                    "(3) -> Add Ham, Swish, & Pretzel Sliders\n" +
                    "(4) -> Add Breakfast Grilled Cheese\n" +
                    "(5) -> Exit Back to Home\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> userChoice = "Bacon, Egg, Cheese";
                case "2" -> userChoice = "Sausage, Egg, Cheese";
                case "3" -> userChoice = "Ham, Swish, Pretzel Sliders";
                case "4" -> userChoice = "Breakfast Grilled Cheese";
                case "5" -> isUserInMenu = false;
                default -> {
                    System.out.println("Invalid user input!");
                    invalidInput = true;
                }
            }

            if (isUserInMenu&&!invalidInput) {

                BreakfastSandwiches breakfastSandwiches = new BreakfastSandwiches("BreakfastSandwiches",
                        0, "Small", 1);
                switch (userChoice.toLowerCase()) {
                    case "bacon, egg, cheese" -> {
                        breakfastSandwiches.setBreakfastSandwich(BreakfastSandwiches.SandwichTypes.BACONEGGCHEESE);
                        largeMediumSmallPrice = BreakfastSandwiches.SandwichTypes.BACONEGGCHEESE.getSmallMediumLargePrice();
                    }
                    case "sausage, egg, cheese" -> {
                        breakfastSandwiches.setBreakfastSandwich(BreakfastSandwiches.SandwichTypes.SAUSAGUEEGGCHEESE);
                        largeMediumSmallPrice = BreakfastSandwiches.SandwichTypes.SAUSAGUEEGGCHEESE.getSmallMediumLargePrice();
                    }
                    case "ham, swish, pretzel sliders" -> {
                        breakfastSandwiches.setBreakfastSandwich(BreakfastSandwiches.SandwichTypes.HAMSWISHPRETEZELSLIDERS);
                        largeMediumSmallPrice = BreakfastSandwiches.SandwichTypes.HAMSWISHPRETEZELSLIDERS.getSmallMediumLargePrice();
                    }
                    case "breakfast grilled cheese" -> {
                        breakfastSandwiches.setBreakfastSandwich(BreakfastSandwiches.SandwichTypes.BREAKFASTGRILLEDCHEESE);
                        largeMediumSmallPrice = BreakfastSandwiches.SandwichTypes.BREAKFASTGRILLEDCHEESE.getSmallMediumLargePrice();
                    }
                    default -> System.out.println("Coffee type does not exist");
                }

                size = sizeSelectionProcess(largeMediumSmallPrice, breakfastSandwiches.getPrice());
                breakfastSandwiches.setServingSize(size);
                breakfastSandwiches.setPrice(breakfastSandwiches.getPrice() +
                        breakfastSandwiches.getPriceForSize(size, largeMediumSmallPrice));

                addExtraMeatProcess(breakfastSandwiches);

                shoppingCart.add(breakfastSandwiches);
                isUserInMenu = false;
            }


        }
    }

    public static void addBakedGoods() {
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0,0,0};

        while (isUserInMenu) {
            boolean invalidInput = false;

            System.out.println("====----- Baked Goods Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            System.out.print("(1) -> Add English Muffins\n" +
                    "(2) -> Add Croissants\n" +
                    "(3) -> Add Bagels\n" +
                    "(4) -> Add Toast\n" +
                    "(5) -> Exit Back to Home\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> userChoice = "English Muffins";
                case "2" -> userChoice = "Croissant";
                case "3" -> userChoice = "Bagel";
                case "4" -> userChoice = "Toast";
                case "5" -> isUserInMenu = false;
                default -> {
                    System.out.println("Invalid user input!");
                    invalidInput = true;
                }
            }

            if (isUserInMenu&&!invalidInput) {

                BakedGoods bakedGoods = new BakedGoods("BakedGoods",
                        0, "Small", 1);
                switch (userChoice.toLowerCase()) {
                    case "english muffins" -> {
                        bakedGoods.setBakedGoods(BakedGoods.BakedGoodsType.ENGLISHMUFFINS);
                        largeMediumSmallPrice = BakedGoods.BakedGoodsType.ENGLISHMUFFINS.getSmallMediumLargePrice();
                    }
                    case "croissant" -> {
                        bakedGoods.setBakedGoods(BakedGoods.BakedGoodsType.CROISSANTS);
                        largeMediumSmallPrice = BakedGoods.BakedGoodsType.CROISSANTS.getSmallMediumLargePrice();
                    }
                    case "bagel" -> {
                        bakedGoods.setBakedGoods(BakedGoods.BakedGoodsType.BAGELS);
                        largeMediumSmallPrice = BakedGoods.BakedGoodsType.BAGELS.getSmallMediumLargePrice();
                    }
                    case "toast" -> {
                        bakedGoods.setBakedGoods(BakedGoods.BakedGoodsType.TOAST);
                        largeMediumSmallPrice = BakedGoods.BakedGoodsType.TOAST.getSmallMediumLargePrice();
                    }
                    default -> System.out.println("BakedGoods type does not exist");
                }
                size = sizeSelectionProcess(largeMediumSmallPrice, bakedGoods.getPrice());
                bakedGoods.setServingSize(size);
                bakedGoods.setPrice(bakedGoods.getPrice() + bakedGoods.getPriceForSize(size, largeMediumSmallPrice));

                addExtraMeatProcess(bakedGoods);

                shoppingCart.add(bakedGoods);
                isUserInMenu = false;
            }

        }
    }

    public static void addSnacksProcess() {
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0,0,0};

        while (isUserInMenu) {
            boolean invalidInput = false;

            System.out.println("====----- Snacks Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            System.out.print("(1) -> Add Doritos\n" +
                    "(2) -> Add Cheetos\n" +
                    "(3) -> Add Peanuts\n" +
                    "(4) -> Add Health Bars\n" +
                    "(5) -> Exit Back to Home\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> userChoice = "Doritos";
                case "2" -> userChoice = "Cheetos";
                case "3" -> userChoice = "Peanuts";
                case "4" -> userChoice = "Health Bars";
                case "5" -> isUserInMenu = false;
                default -> {
                    System.out.println("Invalid user input!");
                    invalidInput = true;
                }
            }

            if (isUserInMenu&&!invalidInput) {

                Snacks snacks = new Snacks("Snacks",
                        0, "Small", 1);
                switch (userChoice.toLowerCase()) {
                    case "doritos" -> {
                        snacks.setSnackType(Snacks.SnackType.DORITOS);
                        largeMediumSmallPrice = Snacks.SnackType.DORITOS.getSmallMediumLargePrice();
                    }
                    case "cheetos" -> {
                        snacks.setSnackType(Snacks.SnackType.CHEETOS);
                        largeMediumSmallPrice = Snacks.SnackType.CHEETOS.getSmallMediumLargePrice();
                    }
                    case "peanuts" -> {
                        snacks.setSnackType(Snacks.SnackType.PEANUTS);
                        largeMediumSmallPrice = Snacks.SnackType.PEANUTS.getSmallMediumLargePrice();
                    }
                    case "health bars" -> {
                        snacks.setSnackType(Snacks.SnackType.HEALTHBARS);
                        largeMediumSmallPrice = Snacks.SnackType.HEALTHBARS.getSmallMediumLargePrice();
                    }
                    default -> System.out.println("BakedGoods type does not exist");
                }
                size = sizeSelectionProcess(largeMediumSmallPrice, snacks.getPrice());
                snacks.setServingSize(size);
                snacks.setPrice(snacks.getPrice() + snacks.getPriceForSize(size, largeMediumSmallPrice));

                shoppingCart.add(snacks);
                isUserInMenu = false;
            }

        }

    }

    public static void addDessertsProcess() {
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0,0,0};

        while (isUserInMenu) {
            boolean invalidInput = false;

            System.out.println("====----- Desserts Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            System.out.print("(1) -> Add Pumpkin Pie\n" +
                    "(2) -> Add Cupcake\n" +
                    "(3) -> Add Coffee Cake\n" +
                    "(4) -> Add Ice Cream\n" +
                    "(5) -> Exit Back to Home\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> userChoice = "Pumpkin Pie";
                case "2" -> userChoice = "Cupcake";
                case "3" -> userChoice = "Coffee Cake";
                case "4" -> userChoice = "Ice Cream";
                case "5" -> isUserInMenu = false;
                default -> {
                    System.out.println("Invalid user input!");
                    invalidInput = true;
                }
            }

            if (isUserInMenu&&!invalidInput) {

                Desserts desserts = new Desserts("Desserts",
                        0, "Small", 1);
                switch (userChoice.toLowerCase()) {
                    case "pumpkin pie" -> {
                        desserts.setDesserts(Desserts.DessertType.PUMPKINPIE);
                        largeMediumSmallPrice = Desserts.DessertType.PUMPKINPIE.getSmallMediumLargePrice();
                    }
                    case "cupcake" -> {
                        desserts.setDesserts(Desserts.DessertType.CUPCAKE);
                        largeMediumSmallPrice = Desserts.DessertType.CUPCAKE.getSmallMediumLargePrice();
                    }
                    case "coffee cake" -> {
                        desserts.setDesserts(Desserts.DessertType.COFFEECAKE);
                        largeMediumSmallPrice = Desserts.DessertType.COFFEECAKE.getSmallMediumLargePrice();
                    }
                    case "ice cream" -> {
                        desserts.setDesserts(Desserts.DessertType.ICECREAM);
                        largeMediumSmallPrice = Desserts.DessertType.ICECREAM.getSmallMediumLargePrice();
                    }
                    default -> System.out.println("BakedGoods type does not exist");
                }
                size = sizeSelectionProcess(largeMediumSmallPrice, desserts.getPrice());
                desserts.setServingSize(size);
                desserts.setPrice(desserts.getPrice() + desserts.getPriceForSize(size, largeMediumSmallPrice));

                shoppingCart.add(desserts);
                isUserInMenu = false;
            }

        }
    }

    public static void viewCartProcess() {
        shoppingCart.getCart().forEach(p -> System.out.println(p));
    }

    public static void checkOutProcess() {
        boolean isUserInLoop = true;
        double totalAmount = shoppingCart.getCart().stream().mapToDouble(p -> p.getPrice()).sum();

        while (isUserInLoop) {
            System.out.println("Total Amount Is: " + totalAmount);
            System.out.print("Do you want to checkout (Y/N)\nType Here:");
            switch (sc.nextLine().trim().toLowerCase()) {
                case "n" -> isUserInLoop = false;
                case "y" -> {
                    InventoryLogger.receiptWriter(shoppingCart);
                    shoppingCart.getCart().clear();
                    isUserInLoop = false;
                }
                default -> System.out.println("Invalid User input");
            }
        }
    }

    public static void cancelOrderProcess() {
        shoppingCart.getCart().clear();
        System.out.println("Inventory CLEARED");
    }

    public static String sizeSelectionProcess(double[] variablePrices, double defaultPrice) {
        boolean isUserInMenu = true;
        String userChoice = "";

        while (isUserInMenu) {

            System.out.println("====----- Size Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            System.out.print("(1) -> Add Large [Price: " + (variablePrices[2] + defaultPrice)+ "]\n" +
                    "(2) -> Add Medium [Price: " + (variablePrices[1] + defaultPrice) + "]\n" +
                    "(3) -> Add Small [Price: " + (variablePrices[0] + defaultPrice) + "]\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> userChoice = "Large";
                case "2" -> userChoice = "Medium";
                case "3" -> userChoice = "Small";
                default -> System.out.println("Invalid user input!");
            }
            if (!userChoice.equalsIgnoreCase("")) {
                isUserInMenu = false;
            }
        }
        return userChoice;
    }

    public static void selectAddInProcess(Product coffee) {
        boolean isUserInMenu = true;
        String switcher = "Add", inverseSwitcher = "Remove";

        while (isUserInMenu) {

            System.out.println("====----- AddIn Selection Screen -----====");
            System.out.printf("(1) -> %s Sweeteners\n" +
                    "(2) -> %s Creamers\n" +
                    "(3) -> %s Spices\n" +
                    "(4) -> %s Flavorings\n" +
                    "(5) -> %s Desert-Style\n" +
                    "(6) -> Switch to %s AddIn\n" +
                    "(7) -> Exit AddIn Menu\n" +
                    "Type Here: ", switcher, switcher, switcher, switcher, switcher, inverseSwitcher);

            switch (sc.nextLine().trim()) {
                case "1" -> addSweetenerProcess(coffee, switcher);
                case "2" -> addCreamersProcess(coffee, switcher);
                case "3" -> addSpicesProcess(coffee, switcher);
                case "4" -> addFlavoringsProcess(coffee, switcher);
                case "5" -> addDesertStyleProcess(coffee, switcher);
                case "6" -> {
                    if (switcher.equalsIgnoreCase("Add")) {
                        switcher = "Remove";
                        inverseSwitcher = "Add";
                    }
                    else {
                        switcher = "Add";
                        inverseSwitcher = "Remove";
                    }
                }
                case "7" -> isUserInMenu = false;
                default -> System.out.println("Invalid user input!");
            }
            if (isUserInMenu == true) {
                System.out.println(coffee);
            }
        }
    }

    public static void addExtraMeatProcess(Product breakfastMeals) {
        BreakfastSandwiches test = new BreakfastSandwiches("",1,"",1);
        String switcher = "Add", inverseSwitcher = "Remove",userChoice = "";
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Extra Meats Selection Screen -----====");
            System.out.printf("(1) -> %s Sausage [Price: " + (test.getPriceForSize(breakfastMeals.getServingSize(),
                    MeatTypes.SAUSAGE.getBreakfastMeatPrice()) + MeatTypes.SAUSAGE.getPrice()) + "]\n" +
                    "(2) -> %s Cheese [Price: " + (test.getPriceForSize(breakfastMeals.getServingSize(),
                    MeatTypes.CHEESE.getBreakfastMeatPrice()) + MeatTypes.CHEESE.getPrice()) + "]\n" +
                    "(3) -> %s Egg [Price: " + (test.getPriceForSize(breakfastMeals.getServingSize(),
                    MeatTypes.EGG.getBreakfastMeatPrice()) + MeatTypes.EGG.getPrice()) + "]\n" +
                    "(4) -> %s Bacon [Price: " + (test.getPriceForSize(breakfastMeals.getServingSize(),
                    MeatTypes.BACON.getBreakfastMeatPrice()) +  MeatTypes.SAUSAGE.getPrice()) + "]\n" +
                    "(5) -> Switch to %s Extra Meats\n" +
                    "(6) -> Exit Extra Meats Menu\n" +
                    "Type Here: ",switcher,switcher,switcher,switcher,inverseSwitcher);

            userChoice = sc.nextLine();

            if (userChoice.equalsIgnoreCase("5")) {

                if (switcher.equalsIgnoreCase("Add")) {
                    switcher = "Remove";
                    inverseSwitcher = "Add";
                }
                else {
                    switcher = "Add";
                    inverseSwitcher = "Remove";
                }
            }

            else if (breakfastMeals instanceof BreakfastSandwiches) {

                if (switcher.equalsIgnoreCase("Add")) {

                    switch (userChoice) {
                        case "1" -> ((BreakfastSandwiches) breakfastMeals).add(MeatTypes.SAUSAGE);
                        case "2" -> ((BreakfastSandwiches) breakfastMeals).add(MeatTypes.CHEESE);
                        case "3" -> ((BreakfastSandwiches) breakfastMeals).add(MeatTypes.EGG);
                        case "4" -> ((BreakfastSandwiches) breakfastMeals).add(MeatTypes.BACON);
                        case "6" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
                else {
                    switch (userChoice) {
                        case "1" -> ((BreakfastSandwiches) breakfastMeals).remove(MeatTypes.SAUSAGE);
                        case "2" -> ((BreakfastSandwiches) breakfastMeals).remove(MeatTypes.CHEESE);
                        case "3" -> ((BreakfastSandwiches) breakfastMeals).remove(MeatTypes.EGG);
                        case "4" -> ((BreakfastSandwiches) breakfastMeals).remove(MeatTypes.BACON);
                        case "6" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
            }

            else if (breakfastMeals instanceof BakedGoods) {

                if (switcher.equalsIgnoreCase("Add")) {
                    switch (userChoice) {
                        case "1" -> ((BakedGoods) breakfastMeals).add(MeatTypes.SAUSAGE);
                        case "2" -> ((BakedGoods) breakfastMeals).add(MeatTypes.CHEESE);
                        case "3" -> ((BakedGoods) breakfastMeals).add(MeatTypes.EGG);
                        case "4" -> ((BakedGoods) breakfastMeals).add(MeatTypes.BACON);
                        case "6" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
                else {
                    switch (userChoice) {
                        case "1" -> ((BakedGoods) breakfastMeals).remove(MeatTypes.SAUSAGE);
                        case "2" -> ((BakedGoods) breakfastMeals).remove(MeatTypes.CHEESE);
                        case "3" -> ((BakedGoods) breakfastMeals).remove(MeatTypes.EGG);
                        case "4" -> ((BakedGoods) breakfastMeals).remove(MeatTypes.BACON);
                        case "6" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
            }
        }
    }

    public static void addSweetenerProcess(Product coffee, String switcher) {
        Coffee test = new Coffee("",1,"",1);
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Sweetener Selection Screen -----====");
            System.out.printf("(1) -> %s Sugar [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Sweeteners.SUGAR.getLargeMediumSmallPrice()) + "]\n" +
                    "(2) -> %s Honey [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Sweeteners.HONEY.getLargeMediumSmallPrice()) + "]\n" +
                    "(3) -> %s Stevia [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Sweeteners.STEVIA.getLargeMediumSmallPrice()) + "]\n" +
                    "(4) -> %s Syrup [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Sweeteners.SYRUP.getLargeMediumSmallPrice()) + "]\n" +
                    "(5) -> Exit AddIn Menu\n" +
                    "Type Here: ", switcher, switcher, switcher, switcher);

            if (coffee instanceof Coffee) {

                if (switcher.equalsIgnoreCase("Add")) {
                    switch (sc.nextLine().trim()) {

                        case "1" -> ((Coffee) coffee).add(AddIn.Sweeteners.SUGAR);
                        case "2" -> ((Coffee) coffee).add(AddIn.Sweeteners.HONEY);
                        case "3" -> ((Coffee) coffee).add(AddIn.Sweeteners.STEVIA);
                        case "4" -> ((Coffee) coffee).add(AddIn.Sweeteners.SYRUP);
                        case "5" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
                else {
                    switch (sc.nextLine().trim()) {

                        case "1" -> ((Coffee) coffee).remove(AddIn.Sweeteners.SUGAR);
                        case "2" -> ((Coffee) coffee).remove(AddIn.Sweeteners.HONEY);
                        case "3" -> ((Coffee) coffee).remove(AddIn.Sweeteners.STEVIA);
                        case "4" -> ((Coffee) coffee).remove(AddIn.Sweeteners.SYRUP);
                        case "5" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
            }

            else if (coffee instanceof Tea) {

                if (switcher.equalsIgnoreCase("Add")) {
                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Tea) coffee).add(AddIn.Sweeteners.SUGAR);
                        case "2" -> ((Tea) coffee).add(AddIn.Sweeteners.HONEY);
                        case "3" -> ((Tea) coffee).add(AddIn.Sweeteners.STEVIA);
                        case "4" -> ((Tea) coffee).add(AddIn.Sweeteners.SYRUP);
                        case "5" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }

                else {
                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Tea) coffee).remove(AddIn.Sweeteners.SUGAR);
                        case "2" -> ((Tea) coffee).remove(AddIn.Sweeteners.HONEY);
                        case "3" -> ((Tea) coffee).remove(AddIn.Sweeteners.STEVIA);
                        case "4" -> ((Tea) coffee).remove(AddIn.Sweeteners.SYRUP);
                        case "5" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
            }

        }
    }

    public static void addCreamersProcess(Product coffee, String switcher) {
        Coffee test = new Coffee("",1,"",1);
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Creamers Selection Screen -----====");
            System.out.printf("(1) -> %s Milk [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Creamers.MILK.getLargeMediumSmallPrice()) + "]\n" +
                    "(2) -> %s Butter [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Creamers.BUTTER.getLargeMediumSmallPrice()) + "]\n" +
                    "(3) -> %s Almond Milk [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Creamers.ALMONDMILK.getLargeMediumSmallPrice()) + "]\n" +
                    "(4) -> %s Coconut Oil [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Creamers.COCONUTOIL.getLargeMediumSmallPrice()) + "]\n" +
                    "(5) -> %s Oat Milk [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Creamers.OATMILK.getLargeMediumSmallPrice()) + "]\n" +
                    "(6) -> Exit AddIn Menu\n" +
                    "Type Here: ", switcher, switcher, switcher, switcher, switcher);

            if (coffee instanceof Coffee) {

                if (switcher.equalsIgnoreCase("Add")) {

                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Coffee) coffee).add(AddIn.Creamers.MILK);
                        case "2" -> ((Coffee) coffee).add(AddIn.Creamers.BUTTER);
                        case "3" -> ((Coffee) coffee).add(AddIn.Creamers.ALMONDMILK);
                        case "4" -> ((Coffee) coffee).add(AddIn.Creamers.COCONUTOIL);
                        case "5" -> ((Coffee) coffee).add(AddIn.Creamers.OATMILK);
                        case "6" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
                else{
                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Coffee) coffee).remove(AddIn.Creamers.MILK);
                        case "2" -> ((Coffee) coffee).remove(AddIn.Creamers.BUTTER);
                        case "3" -> ((Coffee) coffee).remove(AddIn.Creamers.ALMONDMILK);
                        case "4" -> ((Coffee) coffee).remove(AddIn.Creamers.COCONUTOIL);
                        case "5" -> ((Coffee) coffee).remove(AddIn.Creamers.OATMILK);
                        case "6" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
            }

            else if (coffee instanceof Tea) {

                if (switcher.equalsIgnoreCase("Add")) {
                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Tea) coffee).add(AddIn.Creamers.MILK);
                        case "2" -> ((Tea) coffee).add(AddIn.Creamers.BUTTER);
                        case "3" -> ((Tea) coffee).add(AddIn.Creamers.ALMONDMILK);
                        case "4" -> ((Tea) coffee).add(AddIn.Creamers.COCONUTOIL);
                        case "5" -> ((Tea) coffee).add(AddIn.Creamers.OATMILK);
                        case "6" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
                else {
                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Tea) coffee).remove(AddIn.Creamers.MILK);
                        case "2" -> ((Tea) coffee).remove(AddIn.Creamers.BUTTER);
                        case "3" -> ((Tea) coffee).remove(AddIn.Creamers.ALMONDMILK);
                        case "4" -> ((Tea) coffee).remove(AddIn.Creamers.COCONUTOIL);
                        case "5" -> ((Tea) coffee).remove(AddIn.Creamers.OATMILK);
                        case "6" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
            }
        }
    }

    public static void addSpicesProcess(Product coffee, String switcher) {
        Coffee test = new Coffee("",1,"",1);
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Spices Selection Screen -----====");
            System.out.printf("(1) -> %s Cinnamon [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Spices.CINNAMON.getLargeMediumSmallPrice()) + "]\n" +
                    "(2) -> %s Nutmeg [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Spices.NUTMEG.getLargeMediumSmallPrice()) + "]\n" +
                    "(3) -> %s Cayenne Pepper [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Spices.CAYENNEPEPPER.getLargeMediumSmallPrice()) + "]\n" +
                    "(4) -> %s Cardamom [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Spices.CARDAMOM.getLargeMediumSmallPrice()) + "]\n" +
                    "(5) -> Exit AddIn Menu\n" +
                    "Type Here: ", switcher, switcher, switcher, switcher);

            if (coffee instanceof Coffee) {

                if (switcher.equalsIgnoreCase("Add")) {

                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Coffee) coffee).add(AddIn.Spices.CINNAMON);
                        case "2" -> ((Coffee) coffee).add(AddIn.Spices.NUTMEG);
                        case "3" -> ((Coffee) coffee).add(AddIn.Spices.CAYENNEPEPPER);
                        case "4" -> ((Coffee) coffee).add(AddIn.Spices.CARDAMOM);
                        case "5" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
                else {
                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Coffee) coffee).remove(AddIn.Spices.CINNAMON);
                        case "2" -> ((Coffee) coffee).remove(AddIn.Spices.NUTMEG);
                        case "3" -> ((Coffee) coffee).remove(AddIn.Spices.CAYENNEPEPPER);
                        case "4" -> ((Coffee) coffee).remove(AddIn.Spices.CARDAMOM);
                        case "5" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
            }

            else if (coffee instanceof Tea) {

                if (switcher.equalsIgnoreCase("Add")) {

                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Tea) coffee).add(AddIn.Spices.CINNAMON);
                        case "2" -> ((Tea) coffee).add(AddIn.Spices.NUTMEG);
                        case "3" -> ((Tea) coffee).add(AddIn.Spices.CAYENNEPEPPER);
                        case "4" -> ((Tea) coffee).add(AddIn.Spices.CARDAMOM);
                        case "5" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
                else {
                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Tea) coffee).remove(AddIn.Spices.CINNAMON);
                        case "2" -> ((Tea) coffee).remove(AddIn.Spices.NUTMEG);
                        case "3" -> ((Tea) coffee).remove(AddIn.Spices.CAYENNEPEPPER);
                        case "4" -> ((Tea) coffee).remove(AddIn.Spices.CARDAMOM);
                        case "5" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
            }
        }
    }

    public static void addFlavoringsProcess(Product coffee, String switcher) {
        Coffee test = new Coffee("",1,"",1);
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Flavorings Selection Screen -----====");
            System.out.printf("(1) -> %s Vanilla Extract [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Flavorings.VANILLAEXTRACT.getLargeMediumSmallPrice()) + "]\n" +
                    "(2) -> %s Chocolate Shavings [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Flavorings.CHOCOLATESHAVINGS.getLargeMediumSmallPrice()) + "]\n" +
                    "(3) -> %s Cocoa Nibs [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Flavorings.COCOANIBS.getLargeMediumSmallPrice()) + "]\n" +
                    "(4) -> Exit AddIn Menu\n" +
                    "Type Here: ", switcher, switcher, switcher);

            if (coffee instanceof Coffee) {

                if (switcher.equalsIgnoreCase("Add")) {

                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Coffee) coffee).add(AddIn.Flavorings.VANILLAEXTRACT);
                        case "2" -> ((Coffee) coffee).add(AddIn.Flavorings.CHOCOLATESHAVINGS);
                        case "3" -> ((Coffee) coffee).add(AddIn.Flavorings.COCOANIBS);
                        case "4" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
                else {
                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Coffee) coffee).remove(AddIn.Flavorings.VANILLAEXTRACT);
                        case "2" -> ((Coffee) coffee).remove(AddIn.Flavorings.CHOCOLATESHAVINGS);
                        case "3" -> ((Coffee) coffee).remove(AddIn.Flavorings.COCOANIBS);
                        case "4" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
            }

            else if (coffee instanceof Tea) {

                if (switcher.equalsIgnoreCase("Add")) {
                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Tea) coffee).add(AddIn.Flavorings.VANILLAEXTRACT);
                        case "2" -> ((Tea) coffee).add(AddIn.Flavorings.CHOCOLATESHAVINGS);
                        case "3" -> ((Tea) coffee).add(AddIn.Flavorings.COCOANIBS);
                        case "4" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
                else {
                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Tea) coffee).remove(AddIn.Flavorings.VANILLAEXTRACT);
                        case "2" -> ((Tea) coffee).remove(AddIn.Flavorings.CHOCOLATESHAVINGS);
                        case "3" -> ((Tea) coffee).remove(AddIn.Flavorings.COCOANIBS);
                        case "4" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
            }
        }
    }

    public static void addDesertStyleProcess(Product coffee, String switcher) {
        Coffee test = new Coffee("",1,"",1);
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Desert-Style Selection Screen -----====");
            System.out.printf("(1) -> %s Ice Cream [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.DessertStyle.ICECREAM.getLargeMediumSmallPrice()) + "]\n" +
                    "(2) -> %s Condensed Milk [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.DessertStyle.CONDENSEDMILK.getLargeMediumSmallPrice()) + "]\n" +
                    "(3) -> %s Whipped Cream [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.DessertStyle.WHIPPEDCREAM.getLargeMediumSmallPrice()) + "]\n" +
                    "(4) -> %s Brownie [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.DessertStyle.BROWNIE.getLargeMediumSmallPrice()) + "]\n" +
                    "(5) -> Exit AddIn Menu\n" +
                    "Type Here: ", switcher, switcher, switcher, switcher);

            if (coffee instanceof Coffee) {

                if (switcher.equalsIgnoreCase("Add")) {
                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Coffee) coffee).add(AddIn.DessertStyle.ICECREAM);
                        case "2" -> ((Coffee) coffee).add(AddIn.DessertStyle.CONDENSEDMILK);
                        case "3" -> ((Coffee) coffee).add(AddIn.DessertStyle.WHIPPEDCREAM);
                        case "4" -> ((Coffee) coffee).add(AddIn.DessertStyle.BROWNIE);
                        case "5" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
                else {
                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Coffee) coffee).remove(AddIn.DessertStyle.ICECREAM);
                        case "2" -> ((Coffee) coffee).remove(AddIn.DessertStyle.CONDENSEDMILK);
                        case "3" -> ((Coffee) coffee).remove(AddIn.DessertStyle.WHIPPEDCREAM);
                        case "4" -> ((Coffee) coffee).remove(AddIn.DessertStyle.BROWNIE);
                        case "5" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
            }

            else if (coffee instanceof Tea) {

                if (switcher.equalsIgnoreCase("Add")) {
                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Tea) coffee).add(AddIn.DessertStyle.ICECREAM);
                        case "2" -> ((Tea) coffee).add(AddIn.DessertStyle.CONDENSEDMILK);
                        case "3" -> ((Tea) coffee).add(AddIn.DessertStyle.WHIPPEDCREAM);
                        case "4" -> ((Tea) coffee).add(AddIn.DessertStyle.BROWNIE);
                        case "5" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
                else{
                    switch (sc.nextLine().trim()) {
                        case "1" -> ((Tea) coffee).remove(AddIn.DessertStyle.ICECREAM);
                        case "2" -> ((Tea) coffee).remove(AddIn.DessertStyle.CONDENSEDMILK);
                        case "3" -> ((Tea) coffee).remove(AddIn.DessertStyle.WHIPPEDCREAM);
                        case "4" -> ((Tea) coffee).remove(AddIn.DessertStyle.BROWNIE);
                        case "5" -> isUserInMenu = false;
                        default -> System.out.println("Invalid user input!");
                    }
                }
            }
        }
    }

}
