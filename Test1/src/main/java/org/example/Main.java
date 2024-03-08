package org.example;

import org.example.ui.TextUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextUI ui = new TextUI();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            ui.displayMenu();
            System.out.println("Enter option: ");
            String option = sc.nextLine();
            switch(option) {
                case "1":
                    ui.createProduct();
                    break;
                case "2":
                    ui.editProduct();
                    break;
                case "3":
                    ui.createShoppingCart();
                    break;
                case "4":
                    ui.addToCart();
                    break;
                case "5":
                    ui.removeFromCart();
                    break;
                case "6":
                    ui.displayCartAmount();
                    break;
                case "7":
                    ui.displayCarts();
                    break;
                case "8":
                    flag = false;
                    break;
            }
        }
    }



}