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

    public enum Sweeteners {
        SUGAR("Sugar", 0), SYRUP("Syrup",  0), HONEY("Honey",  0), STEVIA("Stevia",  0);

        private final String label;
        private int amountOfAddIn;

        Sweeteners(String label, int amountOfSweets) {
            this.label = label;
            this.amountOfAddIn = amountOfSweets;
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

        public void setAmountOfSweets(int amountOfSweets) {
            this.amountOfAddIn = amountOfSweets;
        }

        public void addSweet(String servingSize, Product coffee) {
            switch (servingSize) {
                case "Large" -> {
                    amountOfAddIn += 1;
                    coffee.setPrice(coffee.getPrice() + 1.25);
                }
                case "Medium" -> {
                    amountOfAddIn += 1;
                    coffee.setPrice(coffee.getPrice() + 1);
                }
                case "Small" -> {
                    amountOfAddIn += 1;
                    coffee.setPrice(coffee.getPrice() + 0.5);
                }

            }

        }

        public void removeSweet(String servingSize, Product coffee) {
            if (getAmountOfSweets() <= 0) {
                System.out.println("INVALID LENGTH can't remove 0");
                return;
            }

            switch (servingSize) {
                case "Large" -> {
                    amountOfAddIn -= 1;
                    coffee.setPrice(coffee.getPrice() - 1.25);
                }
                case "Medium" -> {
                    amountOfAddIn -= 1;
                    coffee.setPrice(coffee.getPrice() - 1);
                }
                case "Small" -> {
                    amountOfAddIn -= 1;
                    coffee.setPrice(coffee.getPrice() - 0.5);
                }

            }

        }
    }

    public enum Creamers implements AddRemoveExtras {
        MILK("Milk", 0), BUTTER("Butter", 0),
        ALMONDMILK("Almond Milk", 0), COCONUTOIL("Coconut Oil", 0),
        OATMILK("Oat Milk", 0);

        private final String label;
        private int amountOfAddIn;

        Creamers(String label, int amountOfSweets) {
            this.label = label;
            this.amountOfAddIn = amountOfSweets;
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

        public void setAmountOfSweets(int amountOfSweets) {
            this.amountOfAddIn = amountOfSweets;
        }

        @Override
        public void add(String servingSize, Product coffee) {
            switch (servingSize) {
                case "Large" -> {
                    amountOfAddIn += 1;
                    coffee.setPrice(coffee.getPrice() + 1.25);
                }
                case "Medium" -> {
                    amountOfAddIn += 1;
                    coffee.setPrice(coffee.getPrice() + 1);
                }
                case "Small" -> {
                    amountOfAddIn += 1;
                    coffee.setPrice(coffee.getPrice() + 0.5);
                }

            }

        }

        @Override
        public void remove(String servingSize, Product coffee) {
            if (getAmountOfSweets() <= 0) {
                System.out.println("INVALID LENGTH can't remove 0");
                return;
            }

            switch (servingSize) {
                case "Large" -> {
                    amountOfAddIn -= 1;
                    coffee.setPrice(coffee.getPrice() - 1.25);
                }
                case "Medium" -> {
                    amountOfAddIn -= 1;
                    coffee.setPrice(coffee.getPrice() - 1);
                }
                case "Small" -> {
                    amountOfAddIn -= 1;
                    coffee.setPrice(coffee.getPrice() - 0.5);
                }

            }

        }
    }
}
