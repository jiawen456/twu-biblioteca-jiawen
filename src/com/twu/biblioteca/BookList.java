package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> bookList;

    public BookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

}
