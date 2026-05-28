package com.pluralsight.Model.BreakfastMeals;

import com.pluralsight.Interface.AddRemoveExtraMeats;
import com.pluralsight.Model.Product;


import java.util.HashMap;
import java.util.Map;

public class BakedGoods extends Product implements AddRemoveExtraMeats {
    private String bakedGoodsName;
    private Map<MeatTypes, Integer> extraMeats;
    private String meatType;

    public BakedGoods(String name, double price, String servingSize, int quantity) {
        super(name, price, servingSize, quantity);
        this.bakedGoodsName = "";
        this.extraMeats = new HashMap<>();
    }

    public String getSandwichName() {
        return bakedGoodsName;
    }

    public void setSandwichName(String sandwichName) {
        this.bakedGoodsName = sandwichName;
    }

    public Map<MeatTypes, Integer> getExtraMeats() {
        return extraMeats;
    }

    public void add(MeatTypes m) {
        this.extraMeats.put(m, extraMeats.getOrDefault(m,0) + 1);

        if (m == MeatTypes.SAUSAGE)
            setPrice(getPrice() + m.getPrice() + m.getBreakfastMeatPrice()[1]);
        else if (m == MeatTypes.EGG)
            setPrice(getPrice() + m.getPrice() + m.getBreakfastMeatPrice()[1]);
        else if (m == MeatTypes.CHEESE)
            setPrice(getPrice() + m.getPrice() + m.getBreakfastMeatPrice()[1]);
        else if (m == MeatTypes.BACON)
            setPrice(getPrice() + m.getPrice() + m.getBreakfastMeatPrice()[1]);
    }

    public void remove(MeatTypes m) {
        if (!extraMeats.containsKey(m)) {
            System.out.println("INVALID can't remove 0 from list");
            return;
        }

        int amountOfAddIn = extraMeats.get(m);

        if (amountOfAddIn > 0) {
            this.extraMeats.put(m, extraMeats.getOrDefault(m,0) - 1);
            if (extraMeats.get(m) == 0) {
                extraMeats.remove(m);
            }
        }
        else {
            System.out.println("INVALID can't remove 0 from list");
            return;
        }

        if (m == MeatTypes.SAUSAGE)
            setPrice(getPrice() - m.getPrice() - m.getBreakfastMeatPrice()[1]);
        else if (m == MeatTypes.EGG)
            setPrice(getPrice() - m.getPrice() - m.getBreakfastMeatPrice()[1]);
        else if (m == MeatTypes.CHEESE)
            setPrice(getPrice() - m.getPrice() - m.getBreakfastMeatPrice()[1]);
        else if (m == MeatTypes.BACON)
            setPrice(getPrice() - m.getPrice() - m.getBreakfastMeatPrice()[1]);
    }

    //This sets the price for and name for the coffee
    // double[] smallMediumLargePrice
    public void setBakedGoods(BakedGoodsType b) {
        if (b == BakedGoodsType.ENGLISHMUFFINS) {
            setSandwichName("English Muffin");
            setPrice(b.getPrice() + getPriceForSize(getServingSize(), b.getSmallMediumLargePrice()));
        }
        else if (b == BakedGoodsType.BAGELS) {
            setSandwichName("Bagels");
            setPrice(b.getPrice() + getPriceForSize(getServingSize(), b.getSmallMediumLargePrice()));
        }
        else if (b == BakedGoodsType.CROISSANTS) {
            setSandwichName("Croissants");
            setPrice(b.getPrice() + getPriceForSize(getServingSize(), b.getSmallMediumLargePrice()));
        }
        else if (b == BakedGoodsType.TOAST) {
            setSandwichName("Toast");
            setPrice(b.getPrice() + getPriceForSize(getServingSize(), b.getSmallMediumLargePrice()));
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

    public enum BakedGoodsType {
        ENGLISHMUFFINS("English Muffins", 1), CROISSANTS("Croissants", 2),
        BAGELS("Bagels", 1.5),
        TOAST("Toast", 0.75);

        private final String label;
        private final double price;
        private double[] smallMediumLargePrice = {0, 0.75, 1.50};

        BakedGoodsType(String label, double price) {
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