package org.example.models;

import java.util.*;

public class Grocery {
    public static void main(String[] args) {
        startGrocery();

    }

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in); // Scanner objesi oluşturuldu.

        while (true) {
            System.out.println("Welcome to Grocery List. Enter a number :"
                                + "\n" + "Çıkış : 0" + "\n"
                                + "İtem ekleme : 1" + "\n"
                                + "İtem çıkarma : 2");
            String number = scanner.nextLine(); // User inputu aldık.

            if (number.equals("0")) {
                System.out.println("Grocery List durduruldu.");
                scanner.close();
                break;

            } else if (number.equals("1")) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                Scanner inputValue = new Scanner(System.in);
                String input = inputValue.nextLine();
                addItems(input);


            } else if (number.equals("2")) {
                System.out.println("Çıkarılmasını istediğiniz elemanları giriniz.");
                Scanner inputValue = new Scanner(System.in);
                String input = inputValue.nextLine();
                removeItems(input);

            }
        }
    }

    public static void addItems(String input) {

        if(input.contains(",")){
            String[] items = input.split(",");
            for (String item : items) {
                String trimmedItem = item.trim();
                if(checkItemIsInList(trimmedItem)){
                    System.out.println(trimmedItem + " is already in the grocery list.");
                } else{
                    groceryList.add(trimmedItem);
                    System.out.println(trimmedItem + " is adding Grocery List");
                }
            }
            } else {
                String trimmedInput = input.trim();
                if(checkItemIsInList(trimmedInput)){
                    System.out.println(trimmedInput + " is already in the grocery list.");
                } else {
                    groceryList.add(trimmedInput);
                    System.out.println(trimmedInput + " is adding Grocery List");
                }
            }
        printSorted();
        }


    public static void removeItems(String input) {

        if(input.contains(",")){
            String[] items = input.split(",");
            for (String item : items) {
                String trimmedItem = item.trim();
                if(checkItemIsInList(trimmedItem)){
                    groceryList.remove(trimmedItem);
                    System.out.println(trimmedItem + " removed from Grocery List");
                } else {
                    System.out.println(trimmedItem + " is not in Grocery List");
                }
            }
        } else {
            String trimmedInput = input.trim();
            if(checkItemIsInList(trimmedInput)){
                groceryList.remove(trimmedInput);
                System.out.println(trimmedInput + " removed from Grocery List");
            } else {
                System.out.println(trimmedInput + " is not in Grocery List");
            }
        }
        printSorted();
    }


    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted () {
        Collections.sort(groceryList);
        System.out.println("Güncel Sıralı Liste : " + groceryList);
    }
}
