package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.start();

        BookList bookList = new BookList();
        app.displayBookList(bookList);
    }

    public void start() {
        String welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMsg);
    }

    public void displayBookList(BookList bookList) {
        System.out.println("List of Library Books");
        ArrayList<String> books = bookList.getBookList();
        for (String book : books) {
            System.out.println(book);
        }

    }
}
