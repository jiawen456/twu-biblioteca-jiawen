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
        System.out.format("%-32s%-24s%-24s%n", "Title", "Author", "Year Published");
        ArrayList<Book> books = bookList.getBookList();
        for (Book book : books) {
            System.out.format("%-32s%-24s%-4d%n", book.getTitle(), book.getAuthor(), book.getYearPublished());
        }

    }
}
