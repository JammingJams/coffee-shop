package com.pluralsight.View;

import com.pluralsight.Interface.AddIn;
import com.pluralsight.Model.BreakfastMeals.BakedGoods;
import com.pluralsight.Model.BreakfastMeals.BreakfastSandwiches;
import com.pluralsight.Model.Drinks.Coffee;
import com.pluralsight.Model.Drinks.Tea;
import com.pluralsight.Model.OtherItems.Desserts;
import com.pluralsight.Model.OtherItems.Snacks;
import com.pluralsight.Model.SpecialityItems.SpecialCoffee;

import java.util.Map;

public class ListStorage {
        //Coffee Maps
        public static final Map<String, String> coffeeOptions = Map.of("1", "Cappuccino", "2", "Latte",
                "3", "Espresso", "4", "Americano", "5", "Mocha");
        public static final Map<String, Coffee.CoffeeType> coffeeTypeList =
                Map.of("cappuccino", Coffee.CoffeeType.CAPPUCCINO, "latte",
                        Coffee.CoffeeType.LATTE, "espresso", Coffee.CoffeeType.ESPRESSO, "americano",
                        Coffee.CoffeeType.AMERICANO, "mocha", Coffee.CoffeeType.AMERICANO);

        //Tea Maps
        public static final Map<String, String> teaOptions = Map.of(
                "1", "Ube", "2", "Green", "3", "Boba");
        public static final Map<String, Tea.TeaType> teaTypeList = Map.of(
                "ube", Tea.TeaType.UBE, "green", Tea.TeaType.GREEN, "boba", Tea.TeaType.BOBA);

        //BreakfastSandwiches Maps
        public static final Map<String, String> sandwichOptions = Map.of(
                "1", "Bacon, Egg, Cheese",
                "2", "Sausage, Egg, Cheese",
                "3", "Ham, Swish, Pretzel Sliders",
                "4", "Breakfast Grilled Cheese");

        public static final Map<String, BreakfastSandwiches.SandwichTypes> sandwichTypeList = Map.of(
                "bacon, egg, cheese", BreakfastSandwiches.SandwichTypes.BACONEGGCHEESE,
                "sausage, egg, cheese", BreakfastSandwiches.SandwichTypes.SAUSAGUEEGGCHEESE,
                "ham, swish, pretzel sliders", BreakfastSandwiches.SandwichTypes.HAMSWISHPRETEZELSLIDERS,
                "breakfast grilled cheese", BreakfastSandwiches.SandwichTypes.BREAKFASTGRILLEDCHEESE);

        //BakedGoods Maps
        public static final Map<String, String> bakedGoodsOptions = Map.of(
                "1", "English Muffin",
                "2", "Croissant",
                "3", "Bagel",
                "4", "Toast");

        public static final Map<String, BakedGoods.BakedGoodsType> bakedGoodsType = Map.of(
                "english muffin", BakedGoods.BakedGoodsType.ENGLISHMUFFINS,
                "croissant", BakedGoods.BakedGoodsType.CROISSANTS,
                "bagel", BakedGoods.BakedGoodsType.BAGELS,
                "toast", BakedGoods.BakedGoodsType.TOAST);

        //Snacks Maps
        public static final Map<String, String> snackOptions = Map.of(
                "1", "Doritos",
                "2", "Cheetos",
                "3", "Peanuts",
                "4", "Health Bars");

        public static final Map<String, Snacks.SnackType> snackTypeList = Map.of(
                "doritos", Snacks.SnackType.DORITOS,
                "cheetos", Snacks.SnackType.CHEETOS,
                "peanuts", Snacks.SnackType.PEANUTS,
                "health bars", Snacks.SnackType.HEALTHBARS);

        //Desserts Maps
        public static final Map<String, String> dessertOptions = Map.of(
                "1", "Pumpkin Pie",
                "2", "Cupcake",
                "3", "Coffee Cake",
                "4", "Ice Cream");

        public static final Map<String, Desserts.DessertType> dessertTypeList = Map.of(
                "pumpkin pie", Desserts.DessertType.PUMPKINPIE,
                "cupcake", Desserts.DessertType.CUPCAKE,
                "coffee cake", Desserts.DessertType.COFFEECAKE,
                "ice cream", Desserts.DessertType.ICECREAM);

        //SpecialCoffee Maps
        public static final Map<String, String> specialCoffeeOptions = Map.of(
                "1", "Birthday Blitz", "2", "Carameltdown",
                "3", "Choco Mucho", "4", "Creamy's Delight", "5", "Spice my Ice");
        public static final Map<String, SpecialCoffee.SpecialCoffeeType> specialCoffeeTypeList =
            Map.of("birthday blitz", SpecialCoffee.SpecialCoffeeType.BIRTHDAYBLITZ,
                    "carameltdown", SpecialCoffee.SpecialCoffeeType.CARAMELTDOWN,
                    "choco mucho", SpecialCoffee.SpecialCoffeeType.CHOCOMUCHO,
                    "creamy's delight", SpecialCoffee.SpecialCoffeeType.CREAMYSDELIGHT,
                    "spice my ice", SpecialCoffee.SpecialCoffeeType.SPICEMYICE);

        public static final Map<String, AddIn.Sweeteners> sweetenerMap = Map.of(
                "1", AddIn.Sweeteners.SUGAR,
                "2", AddIn.Sweeteners.HONEY,
                "3", AddIn.Sweeteners.STEVIA,
                "4", AddIn.Sweeteners.SYRUP);

        public static final Map<String, AddIn.Creamers> creamerMap = Map.of(
                "1", AddIn.Creamers.MILK,
                "2", AddIn.Creamers.BUTTER,
                "3", AddIn.Creamers.ALMONDMILK,
                "4", AddIn.Creamers.COCONUTOIL,
                "5", AddIn.Creamers.OATMILK);

        public static final Map<String, AddIn.Spices> spiceMap = Map.of(
                "1", AddIn.Spices.CINNAMON,
                "2", AddIn.Spices.NUTMEG,
                "3", AddIn.Spices.CAYENNEPEPPER,
                "4", AddIn.Spices.CARDAMOM);

        public static final Map<String, AddIn.Flavorings> flavoringMap = Map.of(
                "1", AddIn.Flavorings.VANILLAEXTRACT,
                "2", AddIn.Flavorings.CHOCOLATESHAVINGS,
                "3", AddIn.Flavorings.COCOANIBS);

        public static final Map<String, AddIn.DessertStyle> dessertStyleMap = Map.of(
                "1", AddIn.DessertStyle.ICECREAM,
                "2", AddIn.DessertStyle.CONDENSEDMILK,
                "3", AddIn.DessertStyle.WHIPPEDCREAM,
                "4", AddIn.DessertStyle.BROWNIE);
}
