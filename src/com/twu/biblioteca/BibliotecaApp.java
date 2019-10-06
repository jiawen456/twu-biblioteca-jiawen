package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.start();
        app.displayMainMenu();
        app.getMenuInput();
    }

    public void start() {
        String welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMsg);
    }

    public void displayMainMenu() {
        System.out.println("Main Menu");
        System.out.println("List of books");
    }

    public void getMenuInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option from the menu");
        String input = scanner.nextLine();
        menuHandler(input);
    }

    public void menuHandler(String input) {
        if (input.equalsIgnoreCase("List of books")) {
            BookList bookList = new BookList();
            displayBookList(bookList);
        }
    }

    public void displayBookList(BookList bookList) {
        System.out.println("List of Library Books");
        System.out.format("%-32s%-24s%-24s%n", "Title", "Author", "Year Published");
        ArrayList<Book> books = bookList.getBookList();
        for (Book book : books) {
            System.out.format("%-32s%-24s%-4d%n", book.getTitle(), book.getAuthor(), book.getYearPublished());
        }

    }
}
