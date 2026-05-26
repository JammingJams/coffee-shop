package com.pluralsight.Model.Drinks;

import com.pluralsight.Interface.AddIn;
import com.pluralsight.Interface.AddRemoveExtras;
import com.pluralsight.Model.Product;

import java.util.HashMap;
import java.util.Map;

public class Tea extends Product implements AddIn, AddRemoveExtras {
    private int waterToDrinkRatio;
    private String teaTypeName;
    private Map<AddIn, Integer> addIns;

    public Tea(String name, double price, String servingSize, int quantity) {
        super(name, price, servingSize, quantity);
        this.waterToDrinkRatio = waterToDrinkRatio;
        this.addIns = new HashMap<>();
        this.teaTypeName = "";
    }

    public int getWaterToDrinkRatio() {
        return waterToDrinkRatio;
    }

    public void setWaterToDrinkRatio(int waterToDrinkRatio) {
        this.waterToDrinkRatio = waterToDrinkRatio;
    }

    public Map<AddIn, Integer> getAddIns() {
        return addIns;
    }

    public String getTeaTypeName() {
        return teaTypeName;
    }

    public void setTeaTypeName(String teaTypeName) {
        this.teaTypeName = teaTypeName;
    }

    @Override
    public void add(AddIn a) {
        this.addIns.put(a, addIns.getOrDefault(a,0) + 1);

        if (a instanceof AddIn.Sweeteners)
            setPrice(getPrice() + getPriceForSize(servingSize, ((AddIn.Sweeteners) a).getLargeMediumSmallPrice()));
        else if (a instanceof AddIn.Flavorings)
            setPrice(getPrice() + getPriceForSize(servingSize, ((AddIn.Flavorings) a).getLargeMediumSmallPrice()));
        else if (a instanceof AddIn.Creamers)
            setPrice(getPrice() + getPriceForSize(servingSize, ((AddIn.Creamers) a).getLargeMediumSmallPrice()));
        else if (a instanceof AddIn.Spices)
            setPrice(getPrice() + getPriceForSize(servingSize, ((AddIn.Spices) a).getLargeMediumSmallPrice()));
        else if (a instanceof AddIn.DessertStyle)
            setPrice(getPrice() + getPriceForSize(servingSize, ((AddIn.DessertStyle) a).getLargeMediumSmallPrice()));

    }

    @Override
    public void remove(AddIn a) {
        if (!addIns.containsKey(a)) {
            System.out.println("INVALID can't remove 0 from list");
            return;
        }

        int amountOfAddIn = addIns.get(a);

        if (amountOfAddIn > 0) {
            addIns.remove(a);
        }
        else {
            System.out.println("INVALID can't remove 0 from list");
            return;
        }

        if (a instanceof Sweeteners)
            setPrice(getPrice() - getPriceForSize(servingSize, ((Sweeteners) a).getLargeMediumSmallPrice()));
        else if (a instanceof Flavorings)
            setPrice(getPrice() - getPriceForSize(servingSize, ((Flavorings) a).getLargeMediumSmallPrice()));
        else if (a instanceof Creamers)
            setPrice(getPrice() - getPriceForSize(servingSize, ((Creamers) a).getLargeMediumSmallPrice()));
        else if (a instanceof Spices)
            setPrice(getPrice() - getPriceForSize(servingSize, ((Spices) a).getLargeMediumSmallPrice()));
        else if (a instanceof DessertStyle)
            setPrice(getPrice() - getPriceForSize(servingSize, ((DessertStyle) a).getLargeMediumSmallPrice()));

    }

    public void setTeaType(TeaType c) {
        if (c.getLabel().equalsIgnoreCase("Ube")) {
            setTeaTypeName("Ube");
            setPrice(c.getPrice() + getPriceForSize(getServingSize(), c.getSmallMediumLargePrices()));
        }
        else if (c.getLabel().equalsIgnoreCase("Green")) {
            setTeaTypeName("Green");
            setPrice(c.getPrice() + getPriceForSize(getServingSize(), c.getSmallMediumLargePrices()));
        }
        else if (c.getLabel().equalsIgnoreCase("Boba")) {
            setTeaTypeName("Boba");
            setPrice(c.getPrice() + getPriceForSize(getServingSize(), c.getSmallMediumLargePrices()));
        }

    }



    @Override
    public String toString() {
        String amountOfAddIn = "";

        if (getAddIns() == null) {
            return String.format("%s|%s|%.2f|%s|x%d", getName(), getTeaTypeName(), getPrice(), getServingSize(), getQuantity());
        }

        for (AddIn a : getAddIns().keySet()) {
            amountOfAddIn += a + "|x" + getAddIns().get(a) + "|";
        }

        int index = amountOfAddIn.lastIndexOf("|");

        if (index == -1) {
            return String.format("%s|%s|%.2f|%s|x%d", getName(), getTeaTypeName(), getPrice(), getServingSize(), getQuantity());
        }

        amountOfAddIn = amountOfAddIn.substring(0, index) + "" + amountOfAddIn.substring(index + 1);
        return String.format("%s|%s|%.2f|%s|x%d|%s",
                getName(), getTeaTypeName(), getPrice(), getServingSize(), getQuantity(), amountOfAddIn);
    }

    public enum TeaType {
        UBE("Ube", 5), GREEN("Green", 5), BOBA("Boba", 5);

        private final String label;
        private final double[] smallMediumLargePrices = {0, 2.5, 5};
        private final double price;

        TeaType(String label, double price) {
            this.label = label;
            this.price = price;
        }

        public String getLabel() {
            return label;
        }

        public double getPrice() {
            return price;
        }

        public double[] getSmallMediumLargePrices() {
            return smallMediumLargePrices;
        }

        @Override
        public String toString() {
            return label;
        }
    }

}
