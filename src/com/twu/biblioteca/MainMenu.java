package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {
    private ArrayList<String> menuOptions;
    public BookList bookList;

    public MainMenu() {
        ArrayList<String> menuOptions = new ArrayList<String>();
        menuOptions.add("List of books");
        menuOptions.add("Checkout books");
        menuOptions.add("Quit");
        this.menuOptions = menuOptions;
        this.bookList = new BookList();
    }

    public void displayMainMenu() {
        System.out.println("Menu");

        for (String option : menuOptions) {
            System.out.println(option);
        }
    }

    public boolean processMenuInput(String input) {
        if (input.equalsIgnoreCase("List of books")) {
            this.bookList.displayBookList();
        } else if (input.equalsIgnoreCase("Quit")) {
            return false;
        } else {
            System.out.println("Please select a valid option!");

        }
        return true;
    }
}
