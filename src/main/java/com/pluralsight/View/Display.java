package com.pluralsight.View;

import com.pluralsight.Controller.InventoryLogger;
import com.pluralsight.Interface.AddIn;
import com.pluralsight.Model.Product;
import com.pluralsight.Model.ShoppingCart;
import com.pluralsight.Model.SpecialityItems.SpecialCoffee;

import java.util.HashMap;
import java.util.Scanner;

public class Display {
    public static Scanner sc = new Scanner(System.in);
    public static ShoppingCart shoppingCart = new ShoppingCart();
    public static HashMap<String, Product> coffeeShopInventory = InventoryLogger.getInventory();
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
                    MenuManager.addCoffeeProcess();
                    isUserInMenu = false;
                }
                case "2" -> {
                    MenuManager.addTeaProcess();
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
                    MenuManager.addBakedGoods();
                    isUserInMenu = false;
                }
                case "2" -> {
                    MenuManager.addBreakfastSandwiches();
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
                case "1" -> MenuManager.addSnacksProcess();
                case "2" -> MenuManager.addDessertsProcess();
                case "3" -> isUserInMenu = false;
                default -> System.out.println("Invalid user input!");
            }
        }

    }

    public static void addSpecialityItemProcess() {
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0, 0, 0};

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

            if (isUserInMenu && !invalidInput) {

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
                String parsedItemName = coffee.getCoffeeTypeName().replaceAll("\\s+", "")
                        .replaceAll(",", "").replaceAll("&", "");
                String itemKey = "SpecialCoffee|" + parsedItemName;
                System.out.println(largeMediumSmallPrice[0]);

                size = MenuManager.sizeSelectionProcess(largeMediumSmallPrice, coffee.getPrice(), itemKey);
                coffee.setServingSize(size);
                coffee.setPrice(coffee.getPrice() + coffee.getPriceForSize(size, largeMediumSmallPrice));

                MenuManager.selectAddInProcess(coffee);

                shoppingCart.add(coffee);

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
            System.out.println("====----- Checkout Screen -----====");
            System.out.println("Total Amount Is: $" + totalAmount);
            System.out.print("Do you want to checkout (Y/N)\nType Here:");
            switch (sc.nextLine().trim().toLowerCase()) {
                case "n" -> isUserInLoop = false;
                case "y" -> {
                    InventoryLogger.receiptWriter(shoppingCart);
                    shoppingCart.getCart().clear();
                    //Add a writer here
                    isUserInLoop = false;
                }
                default -> System.out.println("Invalid User input");
            }
        }
    }

    public static void cancelOrderProcess() {
        shoppingCart.getCart().clear();
        //Add a writer here
        System.out.println("Inventory CLEARED");
    }
}
