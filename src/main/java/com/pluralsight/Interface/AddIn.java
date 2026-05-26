package com.pluralsight.Interface;

public interface AddIn {
    public enum Sweeteners  implements AddIn {
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

    }

    public enum Creamers implements AddIn {
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

    }

    public enum Spices implements AddIn{
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

    }

    public enum Flavorings implements AddIn{
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

    }

    public enum DessertStyle implements AddIn{
        ICECREAM("Ice Cream"), CONDENSEDMILK("Condensed Milk"),
        WHIPPEDCREAM("Whipped Cream"), BROWNIE("Brownie");

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

    }
}
