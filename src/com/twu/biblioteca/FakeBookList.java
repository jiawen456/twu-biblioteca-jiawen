package com.twu.biblioteca;

import java.util.ArrayList;

public class FakeBookList extends BookList{
    private ArrayList<Book> bookList;

    public FakeBookList() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("1984", "George Orwell", 1949));
        bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        bookList.add(new Book("Frankenstein", "Mary Shelly", 1818));
        bookList.add(new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954));

        this.bookList = bookList;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

}
