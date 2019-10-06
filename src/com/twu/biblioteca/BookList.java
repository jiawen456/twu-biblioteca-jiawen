package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    private ArrayList<String> bookList;

    public BookList() {
        ArrayList<String> bookList = new ArrayList<String>();
        bookList.add("1984");
        bookList.add("To Kill a Mockingbird");
        bookList.add("Frankenstein");
        bookList.add("The Lord of the Rings");

        this.bookList = bookList;
    }

    public ArrayList<String> getBookList() {
        return bookList;
    }

}
