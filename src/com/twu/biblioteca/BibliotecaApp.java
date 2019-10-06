package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public boolean isRunning = true;
    private BookList bookList;

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.initialise();
        app.run();
    }

    public void initialise() {
        BookList bookList = setUpBookList();
        this.bookList = bookList;

        String welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMsg);

        displayMainMenu();
    }

    public void run() {
        while (isRunning) {
            getMenuInput();
            if (!isRunning) {
                break;
            }
        }
    }

    public BookList setUpBookList() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("1984", "George Orwell", 1949));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        books.add(new Book("Frankenstein", "Mary Shelly", 1818));
        books.add(new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954));

        return new BookList(books);
    }

    public void displayMainMenu() {
        System.out.println("Main Menu");
        System.out.println("List of books");
        System.out.println("Quit");
    }

    public void getMenuInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option from the menu");
        String input = scanner.nextLine();
        menuHandler(input);
    }

    public void menuHandler(String input) {
        if (input.equalsIgnoreCase("List of books")) {
            displayBookList();
        } else if (input.equalsIgnoreCase("Quit")) {
            isRunning = false;
        } else {
            System.out.println("Please select a valid option!");

        }
    }

    public void displayBookList() {
        System.out.println("List of Library Books");
        System.out.format("%-32s%-24s%-24s%n", "Title", "Author", "Year Published");
        ArrayList<Book> books = this.bookList.getBookList();
        for (Book book : books) {
            System.out.format("%-32s%-24s%-4d%n", book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
    }
}
