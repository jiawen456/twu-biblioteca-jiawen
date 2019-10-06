package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> bookList;

    public BookList() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("1984", "George Orwell", 1949));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        books.add(new Book("Frankenstein", "Mary Shelly", 1818));
        books.add(new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954));

        this.bookList = books;
    }

    public void displayBookList() {
        System.out.println("List of Library Books");
        System.out.format("%-32s%-24s%-24s%n", "Title", "Author", "Year Published");
        for (Book book : bookList) {
            System.out.format("%-32s%-24s%-4d%n", book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
    }

}
