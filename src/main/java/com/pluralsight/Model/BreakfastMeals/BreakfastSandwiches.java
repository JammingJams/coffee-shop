package com.pluralsight.Model.BreakfastMeals;

import com.pluralsight.Interface.AddRemoveExtraMeats;
import com.pluralsight.Model.Product;


import java.util.HashMap;
import java.util.Map;

public class BreakfastSandwiches extends Product implements AddRemoveExtraMeats {
    private String sandwichName;
    private Map<MeatTypes, Integer> extraMeats;
    private String meatType;

    public BreakfastSandwiches(String name, double price, String servingSize, int quantity) {
        super(name, price, servingSize, quantity);
        this.sandwichName = "";
        this.extraMeats = new HashMap<>();
    }

    public String getSandwichName() {
        return sandwichName;
    }

    public void setSandwichName(String sandwichName) {
        this.sandwichName = sandwichName;
    }

    public Map<MeatTypes, Integer> getExtraMeats() {
        return extraMeats;
    }

    public void add(MeatTypes m) {
        this.extraMeats.put(m, extraMeats.getOrDefault(m,0) + 1);
        double extraPrice = 0;

        if (getName().equalsIgnoreCase("BakedGoods")) {
            extraPrice = m.getBreakfastMeatPrice()[1];
        }

        if (m == MeatTypes.SAUSAGE)
            setPrice(getPrice() + m.getPrice() + extraPrice);
        else if (m == MeatTypes.EGG)
            setPrice(getPrice() + m.getPrice() + extraPrice);
        else if (m == MeatTypes.CHEESE)
            setPrice(getPrice() + m.getPrice() + extraPrice);
        else if (m == MeatTypes.BACON)
            setPrice(getPrice() + m.getPrice() + extraPrice);
    }

    public void remove(MeatTypes m) {
        if (!extraMeats.containsKey(m)) {
            System.out.println("INVALID can't remove 0 from list");
            return;
        }

        int amountOfAddIn = extraMeats.get(m);

        if (amountOfAddIn > 0) {
            extraMeats.remove(m);
        }
        else {
            System.out.println("INVALID can't remove 0 from list");
            return;
        }

        double extraPrice = 0;

        if (getName().equalsIgnoreCase("BakedGoods")) {
            extraPrice = m.getBreakfastMeatPrice()[1];
        }

        if (m == MeatTypes.SAUSAGE)
            setPrice(getPrice() + m.getPrice() + extraPrice);
        else if (m == MeatTypes.EGG)
            setPrice(getPrice() + m.getPrice() + extraPrice);
        else if (m == MeatTypes.CHEESE)
            setPrice(getPrice() + m.getPrice() + extraPrice);
        else if (m == MeatTypes.BACON)
            setPrice(getPrice() + m.getPrice() + extraPrice);
    }

    //This sets the price for and name for the coffee
    // double[] smallMediumLargePrice
    public void setBreakfastSandwich(SandwichTypes s) {
        if (s == SandwichTypes.BACONEGGCHEESE) {
            setSandwichName("Bacon, Egg, & Cheese");
            setPrice(s.getPrice() + getPriceForSize(getServingSize(), s.getSmallMediumLargePrice()));
        }
        else if (s == SandwichTypes.SAUSAGUEEGGCHEESE) {
            setSandwichName("Sausage, Egg, & Cheese");
            setPrice(s.getPrice() + getPriceForSize(getServingSize(), s.getSmallMediumLargePrice()));
        }
        else if (s == SandwichTypes.HAMSWISHPRETEZELSLIDERS) {
            setSandwichName("Ham, Swish, Pretzel, & Sliders");
            setPrice(s.getPrice() + getPriceForSize(getServingSize(), s.getSmallMediumLargePrice()));
        }
        else if (s == SandwichTypes.BREAKFASTGRILLEDCHEESE) {
            setSandwichName("Grilled Cheese");
            setPrice(s.getPrice() + getPriceForSize(getServingSize(), s.getSmallMediumLargePrice()));
        }

    }

    @Override
    public String toString() {
        String amountOfAddIn = "";

        if (getExtraMeats() == null) {
            return String.format("%s|%s|%.2f|%s|x%d", getName(), getSandwichName(), getPrice(), getServingSize(), getQuantity());
        }

        for (MeatTypes a : extraMeats.keySet()) {
            amountOfAddIn += a + "|x" + extraMeats.get(a) + "|";
        }

        int index = amountOfAddIn.lastIndexOf("|");

        if (index == -1) {
            return String.format("%s|%s|%.2f|%s|x%d", getName(), getSandwichName(), getPrice(), getServingSize(), getQuantity());
        }

        amountOfAddIn = amountOfAddIn.substring(0, index) + "" + amountOfAddIn.substring(index + 1);
        return String.format("%s|%s|%.2f|%s|x%d|%s",
                getName(), getSandwichName(), getPrice(), getServingSize(), getQuantity(), amountOfAddIn);
    }

    public enum SandwichTypes {
        BACONEGGCHEESE("Bacon, Egg, & Cheese", 4.50), SAUSAGUEEGGCHEESE("Sausage, Egg, & Cheese", 4.50),
        HAMSWISHPRETEZELSLIDERS("Ham, Swish, Pretzel, & Sliders", 7.00),
        BREAKFASTGRILLEDCHEESE("Grilled Cheese", 6.00);

        private final String label;
        private final double price;
        private double[] smallMediumLargePrice = {0, 2.50, 3.50};

        SandwichTypes(String label, double price) {
            this.label = label;
            this.price = price;
            this.smallMediumLargePrice = smallMediumLargePrice;
        }

        public String getLabel() {
            return label;
        }

        public double getPrice() {
            return price;
        }

        public double[] getSmallMediumLargePrice() {
            return smallMediumLargePrice;
        }

        public void setSmallMediumLargePrice(double[] smallMediumLargePrice) {
            this.smallMediumLargePrice = smallMediumLargePrice;
        }

        @Override
        public String toString() {
            return label;
        }

    }
}
