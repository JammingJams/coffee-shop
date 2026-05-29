package com.pluralsight.View;

import com.pluralsight.Controller.InventoryLogger;
import com.pluralsight.Interface.AddIn;
import com.pluralsight.Model.Drinks.Coffee;
import com.pluralsight.Model.Product;
import com.pluralsight.Model.ShoppingCart;
import com.pluralsight.Model.SpecialityItems.SpecialCoffee;

import java.util.*;

import static com.pluralsight.View.MenuManager.checkItemAvailability;

public class Display {
    public static Scanner sc = new Scanner(System.in);
    public static ShoppingCart shoppingCart = new ShoppingCart();
    public static HashMap<String, Product> coffeeShopInventory = InventoryLogger.getInventory();

    private static final Map<String, String> specialCoffeeOptions = ListStorage.specialCoffeeOptions;
    private static final Map<String, SpecialCoffee.SpecialCoffeeType > specialCoffeeTypeList = ListStorage.specialCoffeeTypeList;

    public static void runApp() {
        boolean isUserInMenu = true;

        while (isUserInMenu) {
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Home Screen -----====");
            System.out.print("(1) -> New Order\n" +
                    "(2) -> Exit\n" +
                    "Answer Here: ");
            switch (sc.nextLine().trim()) {
                case "1" -> newOrderProcess();
                case "2" -> isUserInMenu = false;
                default -> waitAndContinue("Invalid user input!");
            }
        }
        System.out.println("Have a good day");

    }

    public static void newOrderProcess() {
        boolean isUserInMenu = true;

        while (isUserInMenu) {
            System.out.println("\n\n\n\n\n\n\n\n\n");
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
                default -> waitAndContinue("Invalid user input!");
            }
        }
    }

    public static void addDrinkProcess() {
        boolean isUserInMenu = true;

        while (isUserInMenu) {
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Drink Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            System.out.print("(1) -> Coffee\n" +
                    "(2) -> Tea\n" +
                    "(3) -> Exit to Order Screen\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> {
                    shoppingCart.add(MenuManager.addCoffeeProcess());
                    isUserInMenu = false;
                }
                case "2" -> {
                    shoppingCart.add(MenuManager.addTeaProcess());
                    isUserInMenu = false;
                }
                case "3" -> isUserInMenu = false;
                default -> waitAndContinue("Invalid user input!");
            }
        }
    }

    public static void addSideItemsProcess() {
        boolean isUserInMenu = true;

        while (isUserInMenu) {
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Breakfast Item Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            System.out.print("(1) -> Baked Goods\n" +
                    "(2) -> Breakfast Sandwiches\n" +
                    "(3) -> Exit to Order Screen\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> {
                    shoppingCart.add(MenuManager.addBakedGoods());
                    isUserInMenu = false;
                }
                case "2" -> {
                    shoppingCart.add(MenuManager.addBreakfastSandwiches());
                    isUserInMenu = false;
                }
                case "3" -> isUserInMenu = false;
                default -> waitAndContinue("Invalid user input!");
            }
        }
    }

    public static void addOtherItemsProcess() {
        boolean isUserInMenu = true;

        while (isUserInMenu) {
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Order Screen -----====");
            System.out.print("(1) -> Add Snacks\n" +
                    "(2) -> Add Desserts\n" +
                    "(3) -> Exit Back to Home\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> shoppingCart.add(MenuManager.addSnacksProcess());
                case "2" -> shoppingCart.add(MenuManager.addDessertsProcess());
                case "3" -> isUserInMenu = false;
                default -> waitAndContinue("Invalid user input!");
            }
        }

    }

    public static void addSpecialityItemProcess() {
        TreeMap<String, String> sortedCoffeeOptions = new TreeMap<>(specialCoffeeOptions);
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0, 0, 0};

        while (isUserInMenu) {
            boolean invalidInput = false;
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Special Coffee Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            for (Map.Entry<String, String> entry : sortedCoffeeOptions.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                boolean isItemAvailable = checkItemAvailability(value);

                if (isItemAvailable) {System.out.printf("(%s) -> Add %s\n", key, value);}
                else {System.out.printf("[%s Unavailable]\n", value);}
            }
            System.out.print("(6) -> Exit Back to Home\nType Here: ");

            String userInput = sc.nextLine().trim();
            userChoice = sortedCoffeeOptions.get(userInput);

            if (userInput.equalsIgnoreCase("6")) {isUserInMenu = false;}

            if (userChoice == null) {
                waitAndContinue("Invalid user input");
                invalidInput = true;
            }

            else if (!checkItemAvailability(userChoice)) {
                String error = userChoice + " is unavailable";
                waitAndContinue(error);
                invalidInput = true;
            }

            if (isUserInMenu && !invalidInput) {

                SpecialCoffee coffee = new SpecialCoffee("SpecialCoffee", 0, "Small", 1);
                SpecialCoffee.SpecialCoffeeType type = specialCoffeeTypeList.get(userChoice.toLowerCase());

                if (type == null) {
                    waitAndContinue("Coffee Type doesn't exist");
                    continue;
                }

                coffee.setCoffeeType(type);
                largeMediumSmallPrice = type.getSmallMediumLargePrice();

                String parsedItemName = coffee.getCoffeeTypeName().replaceAll("\\s+", "")
                        .replaceAll(",", "").replaceAll("&", "");
                String itemKey = "SpecialCoffee|" + parsedItemName;

                size = sizeSelectionProcess(largeMediumSmallPrice, coffee.getPrice(), itemKey);
                coffee.setServingSize(size);
                coffee.setPrice(coffee.getPrice() + coffee.getPriceForSize(size, largeMediumSmallPrice));

                MenuManager.selectAddInProcess(coffee);

                shoppingCart.add(coffee);

                isUserInMenu = false;
            }


        }
    }
    public static void viewCartProcess() {
        shoppingCart.getCart().removeIf(Objects::isNull);
        if (shoppingCart.getCart().isEmpty()) {
            waitAndContinue("Cart doesn't have anything");
            return;
        }
        shoppingCart.getCart().forEach(p -> System.out.println(p));
        waitAndContinue("Pause|Your Cart");
    }

    public static void checkOutProcess() {
        shoppingCart.getCart().removeIf(Objects::isNull);
        boolean isUserInLoop = true;
        double totalAmount = shoppingCart.getCart().stream().mapToDouble(p -> p.getPrice()).sum();
        if (totalAmount == 0) {
            waitAndContinue("Cart doesn't have any products...");
            return;
        }

        while (isUserInLoop) {
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Checkout Screen -----====");
            System.out.println("Total Amount Is: $" + totalAmount);
            System.out.print("Do you want to checkout (Y/N)\nType Here:");
            switch (sc.nextLine().trim().toLowerCase()) {
                case "n" -> isUserInLoop = false;
                case "y" -> {
                    InventoryLogger.receiptWriter(shoppingCart);
                    shoppingCart.getCart().clear();
                    InventoryLogger.inventoryWriter(coffeeShopInventory);
                    waitAndContinue("Pause|Successfully checked out");
                    isUserInLoop = false;
                }
                default -> waitAndContinue("Invalid User input");
            }
        }
    }

    public static void cancelOrderProcess() {
        shoppingCart.getCart().removeIf(Objects::isNull);
        shoppingCart.getCart().clear();
        coffeeShopInventory = InventoryLogger.getInventory();
        waitAndContinue("Pause|Cart Emptied!");
    }

    public static String sizeSelectionProcess(double[] variablePrices, double defaultPrice, String itemName) {
        boolean isUserInMenu = true;
        boolean small = coffeeShopInventory.get(itemName + "|Small").getQuantity() > 0;
        boolean medium = coffeeShopInventory.get(itemName + "|Medium").getQuantity() > 0;
        boolean large = coffeeShopInventory.get(itemName + "|Large").getQuantity() > 0;
        String userChoice = "";

        while (isUserInMenu) {
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Size Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            System.out.println(large ?
                    "(1) -> Add Large [Price: " + (variablePrices[2] + defaultPrice)+ "]" : "Large not Available");
            System.out.println(medium ?
                    "(2) -> Add Medium [Price: " + (variablePrices[1] + defaultPrice)+ "]" : "Medium not Available");
            System.out.println(small ?
                    "(3) -> Add Small [Price: " + (variablePrices[0] + defaultPrice)+ "]" : "Small not Available");
            System.out.print("Type here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> {
                    if (large) {
                        userChoice = "Large";
                        int quantity = coffeeShopInventory.get(itemName + "|Large").getQuantity();
                        coffeeShopInventory.get(itemName + "|Large").setQuantity(quantity - 1);
                    }
                    else {
                        waitAndContinue("Item not available!");
                    }
                }
                case "2" -> {
                    if (medium) {
                        userChoice = "Medium";
                        int quantity = coffeeShopInventory.get(itemName + "|Medium").getQuantity();
                        coffeeShopInventory.get(itemName + "|Medium").setQuantity(quantity - 1);
                    }
                    else {
                        waitAndContinue("Item not available!");
                    }
                }
                case "3" -> {
                    if (small) {
                        userChoice = "Small";
                        int quantity = coffeeShopInventory.get(itemName + "|Small").getQuantity();
                        coffeeShopInventory.get(itemName + "|Small").setQuantity(quantity - 1);
                    }
                    else {
                        waitAndContinue("Item not available!");
                    }
                }
                default -> waitAndContinue("Invalid user input!");
            }
            if (!userChoice.equalsIgnoreCase("")) {
                isUserInMenu = false;
            }
        }
        return userChoice;
    }

    public static void waitAndContinue(String errorMessage){
        if (errorMessage.contains("Pause")) {
            String message = errorMessage.substring(6);
            System.out.println("-----****%%%% User Interaction %%%%****-----");
            System.out.printf("--===!![%s]!!===--\n",message);
            System.out.println("-----****%%%% __________ %%%%****-----");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("##### [Press any key to continue] #####");
            sc.nextLine();
            return;
        }
        System.out.println("-----****%%%% User Error %%%%****-----");
        System.out.printf("--===!![%s]!!===--\n",errorMessage);
        System.out.println("-----****%%%% __________ %%%%****-----");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("##### [Press any key to continue] #####");
        sc.nextLine();
    }
}
