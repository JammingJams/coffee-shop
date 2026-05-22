package com.pluralsight.Model.Drinks;

import com.pluralsight.Interface.AddRemoveExtras;
import com.pluralsight.Model.Product;

public class Coffee extends Product {
    private int waterToDrinkRatio;

    public Coffee(String name, double price, String servingSize, int quantity, int waterToDrinkRatio) {
        super(name, price, servingSize, quantity);
        this.waterToDrinkRatio = waterToDrinkRatio;
    }

    public int getWaterToDrinkRatio() {
        return waterToDrinkRatio;
    }

    public void setWaterToDrinkRatio(int waterToDrinkRatio) {
        this.waterToDrinkRatio = waterToDrinkRatio;
    }

    public enum CoffeeType {
        CAPPUCCINO, LATTE, ESPRESSO, AMERICANO, MOCHA
    }

    public enum Sweeteners  implements AddRemoveExtras{
        SUGAR("Sugar", 0), SYRUP("Syrup",  0),
        HONEY("Honey",  0), STEVIA("Stevia",  0);

        private final String label;
        private double[] largeMediumSmallPrice = {0.5, 1, 1.25};
        private int amountOfAddIn;

        Sweeteners(String label, int amountOfSweets) {
            this.label = label;
            this.amountOfAddIn = amountOfSweets;
            this.largeMediumSmallPrice = largeMediumSmallPrice;
        }

        @Override
        public String toString() {
            return label;
        }

        public String getLabel() {
            return label;
        }

        public int getAmountOfSweets() {
            return amountOfAddIn;
        }

        public double[] getLargeMediumSmallPrice() {
            return largeMediumSmallPrice;
        }

        public void setAmountOfSweets(int amountOfSweets) {
            this.amountOfAddIn = amountOfSweets;
        }

        @Override
        public void add(String servingSize, Product coffee) {
            amountOfAddIn++;
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

        @Override
        public void remove(String servingSize, Product coffee) {
            if (getAmountOfSweets() <= 0) {
                System.out.println("INVALID LENGTH can't remove 0");
                return;
            }
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

    }

    public enum Creamers implements AddRemoveExtras {
        MILK("Milk", 0), BUTTER("Butter", 0),
        ALMONDMILK("Almond Milk", 0), COCONUTOIL("Coconut Oil", 0),
        OATMILK("Oat Milk", 0);

        private final String label;
        private double[] largeMediumSmallPrice = {0.5, 1, 1.25};
        private int amountOfAddIn;

        Creamers(String label, int amountOfSweets) {
            this.label = label;
            this.amountOfAddIn = amountOfSweets;
            this.largeMediumSmallPrice = largeMediumSmallPrice;
        }

        @Override
        public String toString() {
            return label;
        }

        public String getLabel() {
            return label;
        }

        public int getAmountOfCreamers() {
            return amountOfAddIn;
        }

        public double[] getLargeMediumSmallPrice() {
            return largeMediumSmallPrice;
        }

        public void setAmountOfSweets(int amountOfSweets) {
            this.amountOfAddIn = amountOfSweets;
        }

        @Override
        public void add(String servingSize, Product coffee) {
            amountOfAddIn++;
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

        @Override
        public void remove(String servingSize, Product coffee) {
            if (getAmountOfCreamers() <= 0) {
                System.out.println("INVALID LENGTH can't remove 0");
                return;
            }
            amountOfAddIn--;
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

    }

    public enum Spices implements AddRemoveExtras{
        CINNAMON("Cinnamon", 0), NUTMEG("Nutmeg",  0),
        CAYENNEPEPPER("Cayenne Pepper ",  0), CARDAMOM("Cardamom",  0);

        private final String label;
        private double[] largeMediumSmallPrice = {0.5, 1, 1.25};
        private int amountOfAddIn;

        Spices(String label, int amountOfSweets) {
            this.label = label;
            this.amountOfAddIn = amountOfSweets;
            this.largeMediumSmallPrice = largeMediumSmallPrice;
        }

        @Override
        public String toString() {
            return label;
        }

        public String getLabel() {
            return label;
        }

        public int getAmountOfSpices() {
            return amountOfAddIn;
        }

        public double[] getLargeMediumSmallPrice() {
            return largeMediumSmallPrice;
        }

        public void setAmountOfSweets(int amountOfSweets) {
            this.amountOfAddIn = amountOfSweets;
        }

        @Override
        public void add(String servingSize, Product coffee) {
            amountOfAddIn++;
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

        @Override
        public void remove(String servingSize, Product coffee) {
            if (getAmountOfSpices() <= 0) {
                System.out.println("INVALID LENGTH can't remove 0");
                return;
            }
            amountOfAddIn--;
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

    }

    public enum Flavorings implements AddRemoveExtras{
        VANILLAEXTRACT("Vanilla Extract", 0), CHOCOLATESHAVINGS("Chocolate Shavings",  0),
        COCOANIBS("Cocoa Nibs",  0);

        private final String label;
        private double[] largeMediumSmallPrice = {0.5, 1, 1.25};
        private int amountOfAddIn;

        Flavorings(String label, int amountOfSweets) {
            this.label = label;
            this.amountOfAddIn = amountOfSweets;
            this.largeMediumSmallPrice = largeMediumSmallPrice;
        }

        @Override
        public String toString() {
            return label;
        }

        public String getLabel() {
            return label;
        }

        public int getAmountOfFlavorings() {
            return amountOfAddIn;
        }

        public double[] getLargeMediumSmallPrice() {
            return largeMediumSmallPrice;
        }

        public void setAmountOfSweets(int amountOfSweets) {
            this.amountOfAddIn = amountOfSweets;
        }

        @Override
        public void add(String servingSize, Product coffee) {
            amountOfAddIn++;
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

        @Override
        public void remove(String servingSize, Product coffee) {
            if (getAmountOfFlavorings() <= 0) {
                System.out.println("INVALID LENGTH can't remove 0");
                return;
            }
            amountOfAddIn--;
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

    }

    public enum DessertStyle implements AddRemoveExtras{
        ICECREAM("Ice Cream", 0), CONDENSEDMILK("Condensed Milk",  0),
        WHIPPEDCREAM("Whipped Cream",  0), BROWNIE("BROWNIE",  0);

        private final String label;
        private double[] largeMediumSmallPrice = {0.5, 1, 1.25};
        private int amountOfAddIn;

        DessertStyle(String label, int amountOfSweets) {
            this.label = label;
            this.amountOfAddIn = amountOfSweets;
            this.largeMediumSmallPrice = largeMediumSmallPrice;
        }

        @Override
        public String toString() {
            return label;
        }

        public String getLabel() {
            return label;
        }

        public int getAmountOfDessertStyle() {
            return amountOfAddIn;
        }

        public double[] getLargeMediumSmallPrice() {
            return largeMediumSmallPrice;
        }

        public void setAmountOfSweets(int amountOfSweets) {
            this.amountOfAddIn = amountOfSweets;
        }

        @Override
        public void add(String servingSize, Product coffee) {
            amountOfAddIn++;
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

        @Override
        public void remove(String servingSize, Product coffee) {
            if (getAmountOfDessertStyle() <= 0) {
                System.out.println("INVALID LENGTH can't remove 0");
                return;
            }
            amountOfAddIn--;
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

    }
}
