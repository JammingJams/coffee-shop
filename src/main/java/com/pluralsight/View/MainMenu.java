package com.pluralsight.View;

import com.pluralsight.Interface.AddIn;
import com.pluralsight.Model.Drinks.Coffee;
import com.pluralsight.Model.Drinks.Tea;
import com.pluralsight.Model.Product;
import com.pluralsight.Model.ShoppingCart;

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

    public static void addOtherItemsProcess() {

    }

    public static void addSpecialityItemProcess() {

    }

    public static void addCoffeeProcess() {
        boolean isUserInMenu = true, isUserInAddInLoop = false;
        String userChoice = "", size = "";

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
                size = sizeSelectionProcess();
                isUserInAddInLoop = true;

                Coffee coffee = new Coffee("Coffee", 0, size, 1);
                switch (userChoice.toLowerCase()) {
                    case "cappuccino" -> coffee.setCoffeeType(Coffee.CoffeeType.CAPPUCCINO);
                    case "latte" -> coffee.setCoffeeType(Coffee.CoffeeType.LATTE);
                    case "espresso" -> coffee.setCoffeeType(Coffee.CoffeeType.ESPRESSO);
                    case "americano" -> coffee.setCoffeeType(Coffee.CoffeeType.AMERICANO);
                    case "mocha" -> coffee.setCoffeeType(Coffee.CoffeeType.MOCHA);
                    default -> System.out.println("Coffee type does not exist");
                }
                selectAddInProcess(coffee);
                shoppingCart.add(coffee);
                //Test area here
                shoppingCart.getCart().forEach(p -> System.out.println(p));

                isUserInMenu = false;
            }


        }
    }

    public static void addTeaProcess() {
        boolean isUserInMenu = true, isUserInAddInLoop = false;
        String userChoice = "", size = "";

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
                size = sizeSelectionProcess();
                isUserInAddInLoop = true;

                Tea coffee = new Tea("Tea", 0, size, 1);
                switch (userChoice.toLowerCase()) {
                    case "ube" -> coffee.setTeaType(Tea.TeaType.UBE);
                    case "green" -> coffee.setTeaType(Tea.TeaType.GREEN);
                    case "boba" -> coffee.setTeaType(Tea.TeaType.BOBA);
                    default -> System.out.println("Coffee type does not exist");
                }
                selectAddInProcess(coffee);
                shoppingCart.add(coffee);
                isUserInMenu = false;
            }


        }
    }

    public static void viewCartProcess() {

    }

    public static void checkOutProcess() {

    }

    public static void cancelOrderProcess() {

    }

    public static String sizeSelectionProcess() {
        boolean isUserInMenu = true;
        String userChoice = "";

        while (isUserInMenu) {

            System.out.println("====----- Size Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            System.out.print("(1) -> Add Large\n" +
                    "(2) -> Add Medium\n" +
                    "(3) -> Add Small\n" +
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

        while (isUserInMenu) {

            System.out.println("====----- AddIn Selection Screen -----====");
            System.out.print("(1) -> Add Sweeteners\n" +
                    "(2) -> Add Creamers\n" +
                    "(3) -> Add Spices\n" +
                    "(4) -> Add Flavorings\n" +
                    "(5) -> Add Desert-Style\n" +
                    "(6) -> Exit AddIn Menu\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> addSweetenerProcess(coffee);
                case "2" -> addCreamersProcess(coffee);
                case "3" -> addSpicesProcess(coffee);
                case "4" -> addFlavoringsProcess(coffee);
                case "5" -> addDesertStyleProcess(coffee);
                case "6" -> isUserInMenu = false;
                default -> System.out.println("Invalid user input!");
            }
        }
    }

    public static void addSweetenerProcess(Product coffee) {
        Coffee test = new Coffee("",1,"",1);
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Sweetener Selection Screen -----====");
            System.out.print("(1) -> Add Sugar [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Sweeteners.SUGAR.getLargeMediumSmallPrice()) + "]\n" +
                    "(2) -> Add Honey [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Sweeteners.HONEY.getLargeMediumSmallPrice()) + "]\n" +
                    "(3) -> Add Stevia [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Sweeteners.STEVIA.getLargeMediumSmallPrice()) + "]\n" +
                    "(4) -> Add Syrup [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Sweeteners.SYRUP.getLargeMediumSmallPrice()) + "]\n" +
                    "(5) -> Exit AddIn Menu\n" +
                    "Type Here: ");

            if (coffee instanceof Coffee) {

                switch (sc.nextLine().trim()) {
                    case "1" -> ((Coffee) coffee).add(AddIn.Sweeteners.SUGAR);
                    case "2" -> ((Coffee) coffee).add(AddIn.Sweeteners.HONEY);
                    case "3" -> ((Coffee) coffee).add(AddIn.Sweeteners.STEVIA);
                    case "4" -> ((Coffee) coffee).add(AddIn.Sweeteners.SYRUP);
                    case "5" -> isUserInMenu = false;
                    default -> System.out.println("Invalid user input!");
                }
            }

            else if (coffee instanceof Tea) {
                switch (sc.nextLine().trim()) {
                    case "1" -> ((Tea) coffee).add(AddIn.Sweeteners.SUGAR);
                    case "2" -> ((Tea) coffee).add(AddIn.Sweeteners.HONEY);
                    case "3" -> ((Tea) coffee).add(AddIn.Sweeteners.STEVIA);
                    case "4" -> ((Tea) coffee).add(AddIn.Sweeteners.SYRUP);
                    case "5" -> isUserInMenu = false;
                    default -> System.out.println("Invalid user input!");
                }
            }
        }
    }

    public static void addCreamersProcess(Product coffee) {
        Coffee test = new Coffee("",1,"",1);
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Creamers Selection Screen -----====");
            System.out.print("(1) -> Add Milk [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Creamers.MILK.getLargeMediumSmallPrice()) + "]\n" +
                    "(2) -> Add Butter [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Creamers.BUTTER.getLargeMediumSmallPrice()) + "]\n" +
                    "(3) -> Add Almond Milk [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Creamers.ALMONDMILK.getLargeMediumSmallPrice()) + "]\n" +
                    "(4) -> Add Coconut Oil [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Creamers.COCONUTOIL.getLargeMediumSmallPrice()) + "]\n" +
                    "(5) -> Add Oat Milk [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Creamers.OATMILK.getLargeMediumSmallPrice()) + "]\n" +
                    "(6) -> Exit AddIn Menu\n" +
                    "Type Here: ");

            if (coffee instanceof Coffee) {

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

            else if (coffee instanceof Tea) {
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
        }
    }

    public static void addSpicesProcess(Product coffee) {
        Coffee test = new Coffee("",1,"",1);
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Spices Selection Screen -----====");
            System.out.print("(1) -> Add Cinnamon [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Spices.CINNAMON.getLargeMediumSmallPrice()) + "]\n" +
                    "(2) -> Add Nutmeg [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Spices.NUTMEG.getLargeMediumSmallPrice()) + "]\n" +
                    "(3) -> Add Cayenne Pepper [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Spices.CAYENNEPEPPER.getLargeMediumSmallPrice()) + "]\n" +
                    "(4) -> Add Cardamom [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Spices.CARDAMOM.getLargeMediumSmallPrice()) + "]\n" +
                    "(5) -> Exit AddIn Menu\n" +
                    "Type Here: ");

            if (coffee instanceof Coffee) {

                switch (sc.nextLine().trim()) {
                    case "1" -> ((Coffee) coffee).add(AddIn.Spices.CINNAMON);
                    case "2" -> ((Coffee) coffee).add(AddIn.Spices.NUTMEG);
                    case "3" -> ((Coffee) coffee).add(AddIn.Spices.CAYENNEPEPPER);
                    case "4" -> ((Coffee) coffee).add(AddIn.Spices.CARDAMOM);
                    case "5" -> isUserInMenu = false;
                    default -> System.out.println("Invalid user input!");
                }
            }

            else if (coffee instanceof Tea) {
                switch (sc.nextLine().trim()) {
                    case "1" -> ((Tea) coffee).add(AddIn.Spices.CINNAMON);
                    case "2" -> ((Tea) coffee).add(AddIn.Spices.NUTMEG);
                    case "3" -> ((Tea) coffee).add(AddIn.Spices.CAYENNEPEPPER);
                    case "4" -> ((Tea) coffee).add(AddIn.Spices.CARDAMOM);
                    case "5" -> isUserInMenu = false;
                    default -> System.out.println("Invalid user input!");
                }
            }
        }
    }

    public static void addFlavoringsProcess(Product coffee) {
        Coffee test = new Coffee("",1,"",1);
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Flavorings Selection Screen -----====");
            System.out.print("(1) -> Add Vanilla Extract [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Flavorings.VANILLAEXTRACT.getLargeMediumSmallPrice()) + "]\n" +
                    "(2) -> Add Chocolate Shavings [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Flavorings.CHOCOLATESHAVINGS.getLargeMediumSmallPrice()) + "]\n" +
                    "(3) -> Add Cocoa Nibs [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Flavorings.COCOANIBS.getLargeMediumSmallPrice()) + "]\n" +
                    "(4) -> Exit AddIn Menu\n" +
                    "Type Here: ");

            if (coffee instanceof Coffee) {

                switch (sc.nextLine().trim()) {
                    case "1" -> ((Coffee) coffee).add(AddIn.Flavorings.VANILLAEXTRACT);
                    case "2" -> ((Coffee) coffee).add(AddIn.Flavorings.CHOCOLATESHAVINGS);
                    case "3" -> ((Coffee) coffee).add(AddIn.Flavorings.COCOANIBS);
                    case "4" -> isUserInMenu = false;
                    default -> System.out.println("Invalid user input!");
                }
            }

            else if (coffee instanceof Tea) {
                switch (sc.nextLine().trim()) {
                    case "1" -> ((Tea) coffee).add(AddIn.Flavorings.VANILLAEXTRACT);
                    case "2" -> ((Tea) coffee).add(AddIn.Flavorings.CHOCOLATESHAVINGS);
                    case "3" -> ((Tea) coffee).add(AddIn.Flavorings.COCOANIBS);
                    case "4" -> isUserInMenu = false;
                    default -> System.out.println("Invalid user input!");
                }
            }
        }
    }

    public static void addDesertStyleProcess(Product coffee) {
        Coffee test = new Coffee("",1,"",1);
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Desert-Style Selection Screen -----====");
            System.out.print("(1) -> Add Ice Cream [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.DessertStyle.ICECREAM.getLargeMediumSmallPrice()) + "]\n" +
                    "(2) -> Add Condensed Milk [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.DessertStyle.CONDENSEDMILK.getLargeMediumSmallPrice()) + "]\n" +
                    "(3) -> Add Whipped Cream [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.DessertStyle.WHIPPEDCREAM.getLargeMediumSmallPrice()) + "]\n" +
                    "(3) -> Add Brownie [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.DessertStyle.BROWNIE.getLargeMediumSmallPrice()) + "]\n" +
                    "(4) -> Exit AddIn Menu\n" +
                    "Type Here: ");

            if (coffee instanceof Coffee) {

                switch (sc.nextLine().trim()) {
                    case "1" -> ((Coffee) coffee).add(AddIn.DessertStyle.ICECREAM);
                    case "2" -> ((Coffee) coffee).add(AddIn.DessertStyle.CONDENSEDMILK);
                    case "3" -> ((Coffee) coffee).add(AddIn.DessertStyle.WHIPPEDCREAM);
                    case "4" -> ((Coffee) coffee).add(AddIn.DessertStyle.BROWNIE);
                    case "5" -> isUserInMenu = false;
                    default -> System.out.println("Invalid user input!");
                }
            }

            else if (coffee instanceof Tea) {
                switch (sc.nextLine().trim()) {
                    case "1" -> ((Tea) coffee).add(AddIn.DessertStyle.ICECREAM);
                    case "2" -> ((Tea) coffee).add(AddIn.DessertStyle.CONDENSEDMILK);
                    case "3" -> ((Tea) coffee).add(AddIn.DessertStyle.WHIPPEDCREAM);
                    case "4" -> ((Tea) coffee).add(AddIn.DessertStyle.BROWNIE);
                    case "5" -> isUserInMenu = false;
                    default -> System.out.println("Invalid user input!");
                }
            }
        }
    }

}
