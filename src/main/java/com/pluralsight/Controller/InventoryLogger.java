package com.pluralsight.Controller;

import com.pluralsight.Model.BreakfastMeals.BakedGoods;
import com.pluralsight.Model.BreakfastMeals.BreakfastSandwiches;
import com.pluralsight.Model.Drinks.Coffee;
import com.pluralsight.Model.Drinks.Tea;
import com.pluralsight.Model.OtherItems.Desserts;
import com.pluralsight.Model.OtherItems.Snacks;
import com.pluralsight.Model.Product;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class InventoryLogger {

    public static HashMap<String, Product> getInventory() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/CoffeeShopInventory.csv"));

            //This currently just skips the first 2 lines I will later implement a feature that creates a coffee shop
            //instance
            bufferedReader.readLine();
            bufferedReader.readLine();

            String text, key;
            double price = 0;
            int amount = 0;
            HashMap<String, Product> coffeeShopInventory = new HashMap<>();

            while ((text = bufferedReader.readLine()) != null) {

                String[] textSplit = text.split("\\|");
                String type = textSplit[0];
                String name = textSplit[1];
                String size = textSplit[3];

                try {
                    price = Double.parseDouble(textSplit[2]);
                    String splitTwo = textSplit[4].replace("x","");
                    amount = Integer.parseInt(splitTwo);
                }
                catch (NumberFormatException e) {
                    System.out.println("Can't convert a String into an int");
                }

                switch (type.toLowerCase()) {

                    case "coffee" -> {

                        key = String.format("%s|%s|%s", type, name, size);
                        Coffee product = new Coffee(type, price, size, amount);
                        product.setCoffeeTypeName(name);
                        coffeeShopInventory.put(key, product);
                    }
                    case "tea" -> {

                        key = String.format("%s|%s|%s", type, name, size);
                        Tea product = new Tea(type, price, size, amount);
                        product.setTeaTypeName(name);
                        coffeeShopInventory.put(key, product);
                    }
                    case "breakfastsandwiches" -> {

                        key = String.format("%s|%s|%s", type, name, size);
                        BreakfastSandwiches product = new BreakfastSandwiches(type, price, size, amount);
                        product.setSandwichName(name);
                        coffeeShopInventory.put(key, product);
                    }
                    case "bakedgoods" -> {

                        key = String.format("%s|%s|%s", type, name, size);
                        BakedGoods product = new BakedGoods(type, price, size, amount);
                        product.setSandwichName(name);
                        coffeeShopInventory.put(key, product);
                    }
                    case "snacks" -> {

                        key = String.format("%s|%s|%s", type, name, size);
                        Snacks product = new Snacks(type, price, size, amount);
                        product.setSnacksName(name);
                        coffeeShopInventory.put(key, product);
                    }
                    case "desserts" -> {

                        key = String.format("%s|%s|%s", type, name, size);
                        Desserts product = new Desserts(type, price, size, amount);
                        product.setDessertsName(name);
                        coffeeShopInventory.put(key, product);
                    }
                    default -> {
                        System.out.println("This product doesn't exist...");
                    }


                }

            }
            bufferedReader.close();
            return coffeeShopInventory;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void inventoryWriter(HashMap<String, Product> inventory) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/CoffeeShopInventory.csv", false));

            bufferedWriter.write("CoffeeShopsName|Address|Contacts");
            bufferedWriter.newLine();
            bufferedWriter.write("ClassName|InstanceType|Price|ServingSize|Amount");
            bufferedWriter.newLine();

            TreeMap<String, Product> sortedInv = new TreeMap<>(inventory);

            for (Map.Entry<String, Product> entry : sortedInv.entrySet()) {
                System.out.println(entry.getValue());
                String value = String.valueOf(entry.getValue());
                bufferedWriter.write(value);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
