package com.pluralsight.View;

import java.util.Scanner;

public class MainMenu {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Home Screen -----====");
            System.out.print("(1) -> New Order\n" +
                    "(2) -> Exit" +
                    "Answer Here: ");
            switch (sc.nextLine().trim()) {
                case "1" -> newOrderProcess();
                case "2" -> isUserInMenu = false;
                default -> System.out.println("Invalid user input!");
            }
        }
        System.out.println("Have a good day");

    }

    public static void newOrderProcess() {
        boolean isUserInMenu = true;

        while (isUserInMenu) {

            System.out.println("====----- Order Screen -----====");
            System.out.print("(1) -> Add Drink\n" +
                    "(2) -> Add Side Item\n" +
                    "(3) -> Add Snack Item\n" +
                    "(4) -> View Cart\n" +
                    "(5) -> Check Out\n" +
                    "(6) -> Cancel Order\n" +
                    "(7) -> Exit Back to Home\n" +
                    "Type Here: ");

            switch (sc.nextLine().trim()) {
                case "1" -> newOrderProcess();
                case "2" -> addDrinkProcess();
                case "3" -> addSideItemsProcess();
                case "4" -> addOtherItemsProcess();
                case "5" -> viewCartProcess();
                case "6" -> cancelOrderProcess();
                case "7" -> isUserInMenu = false;
                default -> System.out.println("Invalid user input!");
            }
        }
    }

    public static void addDrinkProcess() {

    }

    public static void addSideItemsProcess() {

    }

    public static void addOtherItemsProcess() {

    }

    public static void viewCartProcess() {

    }

    public static void cancelOrderProcess() {

    }
}
