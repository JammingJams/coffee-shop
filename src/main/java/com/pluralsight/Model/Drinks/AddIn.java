package com.pluralsight.Model.Drinks;

import com.pluralsight.Interface.AddRemoveExtras;
import com.pluralsight.Model.Product;

import java.util.Map;

public interface AddIn {
    public enum Sweeteners  implements AddRemoveExtras, AddIn {
        SUGAR("Sugar"), SYRUP("Syrup"),
        HONEY("Honey"), STEVIA("Stevia");

        private final String label;
        private double[] largeMediumSmallPrice = {0.5, 1, 1.25};

        Sweeteners(String label) {
            this.label = label;
            this.largeMediumSmallPrice = largeMediumSmallPrice;
        }

        @Override
        public String toString() {
            return label;
        }

        public String getLabel() {
            return label;
        }


        public double[] getLargeMediumSmallPrice() {
            return largeMediumSmallPrice;
        }


        @Override
        public void add(String servingSize, Product coffee) {
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

        @Override
        public void remove(String servingSize, Product coffee) {
            Map<AddIn, Integer> addIns = null;

            if (coffee instanceof Coffee c) {
                addIns = c.getAddIns();
            }
            else if (coffee instanceof Tea t) {
                addIns = t.getAddIns();
            }
            else {
                System.out.println("ERROR TypeMismatch IE not coffee or tea");
                return;
            }

            if (addIns.getOrDefault(this, 0) <= 0) {
                System.out.println("INVALID LENGTH can't remove 0");
                return;
            }

            coffee.setPrice(coffee.getPrice() - getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

    }

    public enum Creamers implements AddRemoveExtras, AddIn {
        MILK("Milk"), BUTTER("Butter"),
        ALMONDMILK("Almond Milk"), COCONUTOIL("Coconut Oil"),
        OATMILK("Oat Milk");

        private final String label;
        private double[] largeMediumSmallPrice = {0.25, 0.75, 1};

        Creamers(String label) {
            this.label = label;
            this.largeMediumSmallPrice = largeMediumSmallPrice;
        }

        @Override
        public String toString() {
            return label;
        }

        public String getLabel() {
            return label;
        }

        public double[] getLargeMediumSmallPrice() {
            return largeMediumSmallPrice;
        }

        @Override
        public void add(String servingSize, Product coffee) {
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

        @Override
        public void remove(String servingSize, Product coffee) {
            Map<AddIn, Integer> addIns = null;

            if (coffee instanceof Coffee c) {
                addIns = c.getAddIns();
            }
            else if (coffee instanceof Tea t) {
                addIns = t.getAddIns();
            }
            else {
                System.out.println("ERROR TypeMismatch IE not coffee or tea");
                return;
            }

            if (addIns.getOrDefault(this, 0) <= 0) {
                System.out.println("INVALID LENGTH can't remove 0");
                return;
            }

            coffee.setPrice(coffee.getPrice() - getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

    }

    public enum Spices implements AddRemoveExtras, AddIn{
        CINNAMON("Cinnamon"), NUTMEG("Nutmeg"),
        CAYENNEPEPPER("Cayenne Pepper "), CARDAMOM("Cardamom");

        private final String label;
        private double[] largeMediumSmallPrice = {0.35, 0.85, 1.1};

        Spices(String label) {
            this.label = label;
            this.largeMediumSmallPrice = largeMediumSmallPrice;
        }

        @Override
        public String toString() {
            return label;
        }

        public String getLabel() {
            return label;
        }

        public double[] getLargeMediumSmallPrice() {
            return largeMediumSmallPrice;
        }

        @Override
        public void add(String servingSize, Product coffee) {
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

        @Override
        public void remove(String servingSize, Product coffee) {
            Map<AddIn, Integer> addIns = null;

            if (coffee instanceof Coffee c) {
                addIns = c.getAddIns();
            }
            else if (coffee instanceof Tea t) {
                addIns = t.getAddIns();
            }
            else {
                System.out.println("ERROR TypeMismatch IE not coffee or tea");
                return;
            }

            if (addIns.getOrDefault(this, 0) <= 0) {
                System.out.println("INVALID LENGTH can't remove 0");
                return;
            }

            coffee.setPrice(coffee.getPrice() - getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

    }

    public enum Flavorings implements AddRemoveExtras, AddIn{
        VANILLAEXTRACT("Vanilla Extract"), CHOCOLATESHAVINGS("Chocolate Shavings"),
        COCOANIBS("Cocoa Nibs");

        private final String label;
        private double[] largeMediumSmallPrice = {0.75, 1.25, 1.5};

        Flavorings(String label) {
            this.label = label;
            this.largeMediumSmallPrice = largeMediumSmallPrice;
        }

        @Override
        public String toString() {
            return label;
        }

        public String getLabel() {
            return label;
        }

        public double[] getLargeMediumSmallPrice() {
            return largeMediumSmallPrice;
        }

        @Override
        public void add(String servingSize, Product coffee) {
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

        @Override
        public void remove(String servingSize, Product coffee) {
            Map<AddIn, Integer> addIns = null;

            if (coffee instanceof Coffee c) {
                addIns = c.getAddIns();
            }
            else if (coffee instanceof Tea t) {
                addIns = t.getAddIns();
            }
            else {
                System.out.println("ERROR TypeMismatch IE not coffee or tea");
                return;
            }

            if (addIns.getOrDefault(this, 0) <= 0) {
                System.out.println("INVALID LENGTH can't remove 0");
                return;
            }

            coffee.setPrice(coffee.getPrice() - getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

    }

    public enum DessertStyle implements AddRemoveExtras, AddIn{
        ICECREAM("Ice Cream"), CONDENSEDMILK("Condensed Milk"),
        WHIPPEDCREAM("Whipped Cream"), BROWNIE("BROWNIE");

        private final String label;
        private double[] largeMediumSmallPrice = {1, 1.50, 1.75};

        DessertStyle(String label) {
            this.label = label;
            this.largeMediumSmallPrice = largeMediumSmallPrice;
        }

        @Override
        public String toString() {
            return label;
        }

        public String getLabel() {
            return label;
        }

        public double[] getLargeMediumSmallPrice() {
            return largeMediumSmallPrice;
        }

        @Override
        public void add(String servingSize, Product coffee) {
            coffee.setPrice(coffee.getPrice() + getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

        @Override
        public void remove(String servingSize, Product coffee) {
            Map<AddIn, Integer> addIns = null;

            if (coffee instanceof Coffee c) {
                addIns = c.getAddIns();
            }
            else if (coffee instanceof Tea t) {
                addIns = t.getAddIns();
            }
            else {
                System.out.println("ERROR TypeMismatch IE not coffee or tea");
                return;
            }

            if (addIns.getOrDefault(this, 0) <= 0) {
                System.out.println("INVALID LENGTH can't remove 0");
                return;
            }

            coffee.setPrice(coffee.getPrice() - getPriceForSize(servingSize, getLargeMediumSmallPrice()));
        }

    }
}
