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

import java.util.*;

public class MenuManager {
    public static Scanner sc = new Scanner(System.in);
    public static ShoppingCart shoppingCart = new ShoppingCart();
    public static HashMap<String, Product> coffeeShopInventory = Display.coffeeShopInventory;

    //Coffee Maps
    private static final Map<String, String> coffeeOptions = ListStorage.coffeeOptions;
    private static final Map<String, Coffee.CoffeeType> coffeeTypeList = ListStorage.coffeeTypeList;

    //Tea Maps
    private static final Map<String, String> teaOptions = ListStorage.teaOptions;
    private static final Map<String, Tea.TeaType> teaTypeList = ListStorage.teaTypeList;

    //BreakfastSandwiches Maps
    private static final Map<String, String> sandwichOptions = ListStorage.sandwichOptions;
    private static final Map<String, BreakfastSandwiches.SandwichTypes> sandwichTypeList = ListStorage.sandwichTypeList;

    //BakedGoods Maps
    private static final Map<String, String> bakedGoodsOptions = ListStorage.bakedGoodsOptions;
    private static final Map<String, BakedGoods.BakedGoodsType> bakedGoodsType = ListStorage.bakedGoodsType;
    //Snacks Maps
    private static final Map<String, String> snackOptions = ListStorage.snackOptions;
    private static final Map<String, Snacks.SnackType> snackTypeList = ListStorage.snackTypeList;

    //Desserts Maps
    private static final Map<String, String> dessertOptions = ListStorage.dessertOptions;
    private static final Map<String, Desserts.DessertType> dessertTypeList = ListStorage.dessertTypeList;

    //AddIn Maps
    private static final Map<String, AddIn.Sweeteners> sweetenerMap = ListStorage.sweetenerMap;
    private static final Map<String, AddIn.Creamers> creamerMap = ListStorage.creamerMap;
    private static final Map<String, AddIn.Spices> spiceMap = ListStorage.spiceMap;
    private static final Map<String, AddIn.Flavorings> flavoringMap = ListStorage.flavoringMap;
    private static final Map<String, AddIn.DessertStyle> dessertStyleMap = ListStorage.dessertStyleMap;

    public static Product addCoffeeProcess() {
        TreeMap<String, String> sortedCoffeeOptions = new TreeMap<>(coffeeOptions);
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0,0,0};

        while (isUserInMenu) {
            boolean invalidInput = false;
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Coffee Selection Screen -----====");
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

            if (userInput.equalsIgnoreCase("6")) {return null;}

            if (userChoice == null) {
                Display.waitAndContinue("Invalid user input");
                invalidInput = true;
            }

            else if (!checkItemAvailability(userChoice)) {
                String error = (userChoice + " is unavailable");
                Display.waitAndContinue(error);
                invalidInput = true;
            }

            if (isUserInMenu&&!invalidInput) {
                Coffee.CoffeeType type = coffeeTypeList.get(userChoice.toLowerCase());

                if (type == null) {
                    Display.waitAndContinue("Coffee Type doesn't exist");
                    return null;
                }

                Coffee coffee = new Coffee("Coffee", 0, "Small", 1);
                coffee.setCoffeeType(type);
                largeMediumSmallPrice = type.getSmallMediumLargePrice();

                String parsedItemName = coffee.getCoffeeTypeName().replaceAll("\\s+","")
                        .replaceAll(",","").replaceAll("&","");
                String itemKey = "Coffee|" + parsedItemName;

                size = Display.sizeSelectionProcess(largeMediumSmallPrice, coffee.getPrice(), itemKey);
                coffee.setServingSize(size);
                coffee.setPrice(coffee.getPrice() + coffee.getPriceForSize(size, largeMediumSmallPrice));

                selectAddInProcess(coffee);

                shoppingCart.add(coffee);
                return coffee;
            }

        }
        return null;
    }

    public static Product addTeaProcess() {
        TreeMap<String, String> sortedTeaOptions = new TreeMap<>(teaOptions);
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0,0,0};

        while (isUserInMenu) {
            boolean invalidInput = false;
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Tea Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            for (Map.Entry<String, String> entry : sortedTeaOptions.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                boolean isItemAvailable = checkItemAvailability(value);

                if (isItemAvailable) {System.out.printf("(%s) -> Add %s\n", key, value);}
                else {System.out.printf("[%s Unavailable]\n", value);}
            }
            System.out.print("(6) -> Exit Back to Home\nType Here: ");

            String userInput = sc.nextLine().trim();
            userChoice = sortedTeaOptions.get(userInput);

            if (userInput.equalsIgnoreCase("6")) {return null;}

            if (userChoice == null) {
                Display.waitAndContinue("Invalid user input");
                invalidInput = true;
            }

            else if (!checkItemAvailability(userChoice)) {
                String error = (userChoice + " is unavailable");
                Display.waitAndContinue(error);
                invalidInput = true;
            }

            if (isUserInMenu&&!invalidInput) {

                Tea coffee = new Tea("Tea", 0, size, 1);
                Tea.TeaType type = teaTypeList.get(userChoice.toLowerCase());

                if (type == null) {
                    Display.waitAndContinue("Tea Type doesn't exist");
                    return null;
                }

                coffee.setTeaType(type);
                largeMediumSmallPrice = type.getSmallMediumLargePrices();

                String parsedItemName = coffee.getTeaTypeName().replaceAll("\\s+","")
                        .replaceAll(",","").replaceAll("&","");
                String itemKey = "Tea|" + parsedItemName;

                size = Display.sizeSelectionProcess(largeMediumSmallPrice, coffee.getPrice(), itemKey);
                coffee.setServingSize(size);
                coffee.setPrice(coffee.getPrice() + coffee.getPriceForSize(size, largeMediumSmallPrice));
                selectAddInProcess(coffee);

                return coffee;
            }

        }
        return null;
    }

    public static Product addBreakfastSandwiches() {
        TreeMap<String, String> breakfastSandwichOptions = new TreeMap<>(sandwichOptions);
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0,0,0};

        while (isUserInMenu) {
            boolean invalidInput = false;
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Sandwich Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            for (Map.Entry<String, String> entry : breakfastSandwichOptions.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                boolean isItemAvailable = checkItemAvailability(value);

                if (isItemAvailable) {System.out.printf("(%s) -> Add %s\n", key, value);}
                else {System.out.printf("[%s Unavailable]\n", value);}
            }
            System.out.print("(6) -> Exit Back to Home\nType Here: ");

            String userInput = sc.nextLine().trim();
            userChoice = breakfastSandwichOptions.get(userInput);

            if (userInput.equalsIgnoreCase("6")) {return null;}

            if (userChoice == null) {
                Display.waitAndContinue("Invalid user input");
                invalidInput = true;
            }

            else if (!checkItemAvailability(userChoice)) {
                String error = (userChoice + " is unavailable");
                Display.waitAndContinue(error);
                invalidInput = true;
            }

            if (isUserInMenu&&!invalidInput) {

                BreakfastSandwiches breakfastSandwiches = new BreakfastSandwiches("BreakfastSandwiches",
                        0, "Small", 1);
                BreakfastSandwiches.SandwichTypes type = sandwichTypeList.get(userChoice.toLowerCase());

                if (type == null) {
                    Display.waitAndContinue("BreakfastSandwich Type doesn't exist");
                    return null;
                }

                breakfastSandwiches.setBreakfastSandwich(type);
                largeMediumSmallPrice = type.getSmallMediumLargePrice();

                String parsedItemName = breakfastSandwiches.getSandwichName().replaceAll("\\s+","")
                        .replaceAll(",","").replaceAll("&","");
                String itemKey = "BreakfastSandwiches|" + parsedItemName;

                size = Display.sizeSelectionProcess(largeMediumSmallPrice, breakfastSandwiches.getPrice(), itemKey);

                breakfastSandwiches.setServingSize(size);
                breakfastSandwiches.setPrice(breakfastSandwiches.getPrice() +
                        breakfastSandwiches.getPriceForSize(size, largeMediumSmallPrice));

                addExtraMeatProcess(breakfastSandwiches);

                return breakfastSandwiches;
                //isUserInMenu = false;
            }

        }
        return null;
    }

    public static Product addBakedGoods() {
        TreeMap<String, String> bakedGoodOptions = new TreeMap<>(bakedGoodsOptions);
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0,0,0};

        while (isUserInMenu) {
            boolean invalidInput = false;
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Baked Goods Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            for (Map.Entry<String, String> entry : bakedGoodOptions.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                boolean isItemAvailable = checkItemAvailability(value);

                if (isItemAvailable) {System.out.printf("(%s) -> Add %s\n", key, value);}
                else {System.out.printf("[%s Unavailable]\n", value);}
            }
            System.out.print("(6) -> Exit Back to Home\nType Here: ");

            String userInput = sc.nextLine().trim();
            userChoice = bakedGoodOptions.get(userInput);

            if (userInput.equalsIgnoreCase("6")) {return null;}

            if (userChoice == null) {
                Display.waitAndContinue("Invalid user input");
                invalidInput = true;
            }

            else if (!checkItemAvailability(userChoice)) {
                String error = (userChoice + " is unavailable");
                Display.waitAndContinue(error);
                invalidInput = true;
            }

            if (isUserInMenu&&!invalidInput) {

                BakedGoods bakedGoods = new BakedGoods("BakedGoods",
                        0, "Small", 1);
                BakedGoods.BakedGoodsType type = bakedGoodsType.get(userChoice.toLowerCase());

                if (type == null) {
                    Display.waitAndContinue("BakedGoods Type doesn't exist");
                    return null;
                }

                bakedGoods.setBakedGoods(type);
                largeMediumSmallPrice = type.getSmallMediumLargePrice();

                String parsedItemName = bakedGoods.getSandwichName().replaceAll("\\s+","")
                        .replaceAll(",","").replaceAll("&","");
                String itemKey = "BakedGoods|" + parsedItemName;

                size = Display.sizeSelectionProcess(largeMediumSmallPrice, bakedGoods.getPrice(), itemKey);
                bakedGoods.setServingSize(size);
                bakedGoods.setPrice(bakedGoods.getPrice() + bakedGoods.getPriceForSize(size, largeMediumSmallPrice));

                addExtraMeatProcess(bakedGoods);

                return bakedGoods;
            }

        }
        return null;
    }

    public static Product addSnacksProcess() {
        TreeMap<String, String> snackOption = new TreeMap<>(snackOptions);
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0,0,0};

        while (isUserInMenu) {
            boolean invalidInput = false;
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Snacks Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            for (Map.Entry<String, String> entry : snackOption.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                boolean isItemAvailable = checkItemAvailability(value);

                if (isItemAvailable) {System.out.printf("(%s) -> Add %s\n", key, value);}
                else {System.out.printf("[%s Unavailable]\n", value);}
            }
            System.out.print("(6) -> Exit Back to Home\nType Here: ");

            String userInput = sc.nextLine().trim();
            userChoice = snackOption.get(userInput);

            if (userInput.equalsIgnoreCase("6")) {return null;}

            if (userChoice == null) {
                Display.waitAndContinue("Invalid user input");
                invalidInput = true;
            }

            else if (!checkItemAvailability(userChoice)) {
                String error = (userChoice + " is unavailable");
                Display.waitAndContinue(error);
                invalidInput = true;
            }

            if (isUserInMenu&&!invalidInput) {

                Snacks snacks = new Snacks("Snacks",
                        0, "Small", 1);
                Snacks.SnackType type = snackTypeList.get(userChoice.toLowerCase());

                if (type == null) {
                    Display.waitAndContinue("Snack Type doesn't exist");
                    return null;
                }

                snacks.setSnackType(type);
                largeMediumSmallPrice = type.getSmallMediumLargePrice();

                String parsedItemName = snacks.getSnacksName().replaceAll("\\s+","")
                        .replaceAll(",","").replaceAll("&","");
                String itemKey = "Snacks|" + parsedItemName;

                System.out.println(itemKey);
                //These are the process that run
                size = Display.sizeSelectionProcess(largeMediumSmallPrice, snacks.getPrice(), itemKey);

                //This sets the price
                snacks.setServingSize(size);

                snacks.setPrice(snacks.getPrice() + snacks.getPriceForSize(size, largeMediumSmallPrice));

                return snacks;
            }

        }
        return null;
    }

    public static Product addDessertsProcess() {
        TreeMap<String, String> dessertOption = new TreeMap<>(dessertOptions);
        boolean isUserInMenu = true;
        String userChoice = "", size = "";
        double[] largeMediumSmallPrice = {0,0,0};

        while (isUserInMenu) {
            boolean invalidInput = false;
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Desserts Selection Screen -----====");
            System.out.println("<|T--> Select Your Type! <--T|>");
            for (Map.Entry<String, String> entry : dessertOption.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                boolean isItemAvailable = checkItemAvailability(value);

                if (isItemAvailable) {System.out.printf("(%s) -> Add %s\n", key, value);}
                else {System.out.printf("[%s Unavailable]\n", value);}
            }
            System.out.print("(6) -> Exit Back to Home\nType Here: ");

            String userInput = sc.nextLine().trim();
            userChoice = dessertOption.get(userInput);

            if (userInput.equalsIgnoreCase("6")) {return null;}

            if (userChoice == null) {
                Display.waitAndContinue("Invalid user input");
                invalidInput = true;
            }

            else if (!checkItemAvailability(userChoice)) {
                String error = (userChoice + " is unavailable");
                Display.waitAndContinue(error);
                invalidInput = true;
            }

            if (isUserInMenu&&!invalidInput) {

                Desserts desserts = new Desserts("Desserts",
                        0, "Small", 1);
                Desserts.DessertType type = dessertTypeList.get(userChoice.toLowerCase());

                if (type == null) {
                    Display.waitAndContinue("Dessert Type doesn't exist");
                    return null;
                }

                desserts.setDesserts(type);
                largeMediumSmallPrice = type.getSmallMediumLargePrice();

                String parsedItemName = desserts.getDessertsName().replaceAll("\\s+","")
                        .replaceAll(",","").replaceAll("&","");
                String itemKey = "Desserts|" + parsedItemName;

                size = Display.sizeSelectionProcess(largeMediumSmallPrice, desserts.getPrice(), itemKey);
                desserts.setServingSize(size);
                desserts.setPrice(desserts.getPrice() + desserts.getPriceForSize(size, largeMediumSmallPrice));

                return desserts;
            }

        }
        return null;
    }

    public static void selectAddInProcess(Product coffee) {
        boolean isUserInMenu = true;
        String switcher = "Add", inverseSwitcher = "Remove";

        while (isUserInMenu) {
            System.out.println("\n\n\n\n\n\n\n\n\n");
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
                default -> Display.waitAndContinue("Invalid user input!");
            }
            if (isUserInMenu == true) {
                System.out.println("\n\n\n\n\n\n\n\n\n");
                System.out.println(coffee);
                Display.waitAndContinue("Pause|Current AddIn");
            }
        }
    }

    public static void addExtraMeatProcess(Product breakfastMeals) {
        BreakfastSandwiches test = new BreakfastSandwiches("",1,"",1);
        String switcher = "Add", inverseSwitcher = "Remove",userChoice = "";
        boolean isUserInMenu = true;

        while (isUserInMenu) {
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Extra Meats Selection Screen -----====");
            System.out.printf("(1) -> %s Sausage [Price: " + (test.getPriceForSize(breakfastMeals.getServingSize(),
                    MeatTypes.SAUSAGE.getBreakfastMeatPrice()) + MeatTypes.SAUSAGE.getPrice()) + "]\n" +
                    "(2) -> %s Cheese [Price: " + (test.getPriceForSize(breakfastMeals.getServingSize(),
                    MeatTypes.CHEESE.getBreakfastMeatPrice()) + MeatTypes.CHEESE.getPrice()) + "]\n" +
                    "(3) -> %s Egg [Price: " + (test.getPriceForSize(breakfastMeals.getServingSize(),
                    MeatTypes.EGG.getBreakfastMeatPrice()) + MeatTypes.EGG.getPrice()) + "]\n" +
                    "(4) -> %s Bacon [Price: " + (test.getPriceForSize(breakfastMeals.getServingSize(),
                    MeatTypes.BACON.getBreakfastMeatPrice()) +  MeatTypes.BACON.getPrice()) + "]\n" +
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
                        default -> Display.waitAndContinue("Invalid user input!");
                    }
                }
                else {
                    switch (userChoice) {
                        case "1" -> ((BreakfastSandwiches) breakfastMeals).remove(MeatTypes.SAUSAGE);
                        case "2" -> ((BreakfastSandwiches) breakfastMeals).remove(MeatTypes.CHEESE);
                        case "3" -> ((BreakfastSandwiches) breakfastMeals).remove(MeatTypes.EGG);
                        case "4" -> ((BreakfastSandwiches) breakfastMeals).remove(MeatTypes.BACON);
                        case "6" -> isUserInMenu = false;
                        default -> Display.waitAndContinue("Invalid user input!");
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
                        default -> Display.waitAndContinue("Invalid user input!");
                    }
                }
                else {
                    switch (userChoice) {
                        case "1" -> ((BakedGoods) breakfastMeals).remove(MeatTypes.SAUSAGE);
                        case "2" -> ((BakedGoods) breakfastMeals).remove(MeatTypes.CHEESE);
                        case "3" -> ((BakedGoods) breakfastMeals).remove(MeatTypes.EGG);
                        case "4" -> ((BakedGoods) breakfastMeals).remove(MeatTypes.BACON);
                        case "6" -> isUserInMenu = false;
                        default -> Display.waitAndContinue("Invalid user input!");
                    }
                }
            }
            if (isUserInMenu) {
                System.out.println("\n\n\n\n\n\n\n\n\n");
                System.out.println(breakfastMeals);
                Display.waitAndContinue("Pause|Current Extra Meats");
            }
        }
    }

    public static void addSweetenerProcess(Product coffee, String switcher) {
        Coffee test = new Coffee("",1,"",1);
        boolean isUserInMenu = true;
        String input = "";

        while (isUserInMenu) {
            System.out.println("\n\n\n\n\n\n\n\n\n");
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

            switch (sc.nextLine().trim()) {

                case "1" -> input = "1";
                case "2" -> input = "2";
                case "3" -> input = "3";
                case "4" -> input = "4";
                case "5" -> isUserInMenu = false;
                default -> Display.waitAndContinue("Invalid user input!");
            }

            AddIn.Sweeteners selected = sweetenerMap.get(input);

            if (selected == null) {
                Display.waitAndContinue("Invalid user input!");
                continue;
            }
            if (!isUserInMenu) {return;}

            applyAddOrRemoveAddIn(coffee, selected, switcher);
        }
    }

    public static void addCreamersProcess(Product coffee, String switcher) {
        Coffee test = new Coffee("",1,"",1);
        String input = "";
        boolean isUserInMenu = true;

        while (isUserInMenu) {
            System.out.println("\n\n\n\n\n\n\n\n\n");
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

            switch (sc.nextLine().trim()) {

                case "1" -> input = "1";
                case "2" -> input = "2";
                case "3" -> input = "3";
                case "4" -> input = "4";
                case "5" -> input = "5";
                case "6" -> isUserInMenu = false;
                default -> Display.waitAndContinue("Invalid user input!");
            }
            if (!isUserInMenu) {return;}

            AddIn.Creamers selected = creamerMap.get(input);

            if (selected == null) {
                Display.waitAndContinue("Invalid user input!");
                continue;
            }

            applyAddOrRemoveAddIn(coffee, selected, switcher);
        }
    }

    public static void addSpicesProcess(Product coffee, String switcher) {
        Coffee test = new Coffee("",1,"",1);
        String input = "";
        boolean isUserInMenu = true;

        while (isUserInMenu) {
            System.out.println("\n\n\n\n\n\n\n\n\n");
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

            switch (sc.nextLine().trim()) {

                case "1" -> input = "1";
                case "2" -> input = "2";
                case "3" -> input = "3";
                case "4" -> input = "4";
                case "5" -> isUserInMenu = false;
                default -> Display.waitAndContinue("Invalid user input!");
            }
            if (!isUserInMenu) {return;}

            AddIn.Spices selected = spiceMap.get(input);

            if (selected == null) {
                Display.waitAndContinue("Invalid user input!");
                continue;
            }

            applyAddOrRemoveAddIn(coffee, selected, switcher);
        }
    }

    public static void addFlavoringsProcess(Product coffee, String switcher) {
        Coffee test = new Coffee("",1,"",1);
        String input = "";
        boolean isUserInMenu = true;

        while (isUserInMenu) {
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("====----- Flavorings Selection Screen -----====");
            System.out.printf("(1) -> %s Vanilla Extract [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Flavorings.VANILLAEXTRACT.getLargeMediumSmallPrice()) + "]\n" +
                    "(2) -> %s Chocolate Shavings [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Flavorings.CHOCOLATESHAVINGS.getLargeMediumSmallPrice()) + "]\n" +
                    "(3) -> %s Cocoa Nibs [Price: " + test.getPriceForSize(coffee.getServingSize(),
                    AddIn.Flavorings.COCOANIBS.getLargeMediumSmallPrice()) + "]\n" +
                    "(4) -> Exit AddIn Menu\n" +
                    "Type Here: ", switcher, switcher, switcher);

            switch (sc.nextLine().trim()) {

                case "1" -> input = "1";
                case "2" -> input = "2";
                case "3" -> input = "3";
                case "4" -> isUserInMenu = false;
                default -> Display.waitAndContinue("Invalid user input!");
            }
            if (!isUserInMenu) {return;}

            AddIn.Flavorings selected = flavoringMap.get(input);

            if (selected == null) {
                Display.waitAndContinue("Invalid user input!");
                continue;
            }

            applyAddOrRemoveAddIn(coffee, selected, switcher);
        }
    }

    public static void addDesertStyleProcess(Product coffee, String switcher) {
        Coffee test = new Coffee("",1,"",1);
        String input = "";
        boolean isUserInMenu = true;

        while (isUserInMenu) {
            System.out.println("\n\n\n\n\n\n\n\n\n");
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

            switch (sc.nextLine().trim()) {

                case "1" -> input = "1";
                case "2" -> input = "2";
                case "3" -> input = "3";
                case "4" -> input = "4";
                case "5" -> isUserInMenu = false;
                default -> Display.waitAndContinue("Invalid user input!");
            }
            if (!isUserInMenu) {return;}

            AddIn.DessertStyle selected = dessertStyleMap.get(input);

            if (selected == null) {
                Display.waitAndContinue("Invalid user input!");
                continue;
            }

            applyAddOrRemoveAddIn(coffee, selected, switcher);
        }
    }

    //We need to sort out the data to determine if an item is out of stock!
    public static boolean checkItemAvailability(String itemName) {
        coffeeShopInventory = Display.coffeeShopInventory;
        itemName = itemName.replaceAll("\\s+","")
                .replaceAll(",","").replaceAll("&","");

        for (Map.Entry<String, Product> entry : coffeeShopInventory.entrySet()) {
            String key = entry.getKey();
            Product product = entry.getValue();
                if(key.contains(itemName)) {
                    if (product.getQuantity() > 0) {
                        return true;
                    }
            }
        }
        return false;
    }

    private static void applyAddOrRemoveAddIn(Product product, AddIn addon, String switcher) {

        if (product instanceof Coffee coffee) {

            if (switcher.equalsIgnoreCase("Add")) {
                coffee.add(addon);
            } else {
                coffee.remove(addon);
            }

        } else if (product instanceof Tea tea) {

            if (switcher.equalsIgnoreCase("Add")) {
                tea.add(addon);
            } else {
                tea.remove(addon);
            }
        }
    }
}