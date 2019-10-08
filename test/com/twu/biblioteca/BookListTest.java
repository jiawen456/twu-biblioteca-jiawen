package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class BookListTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BookList bookList;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("1984", "George Orwell", 1949));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        books.add(new Book("Frankenstein", "Mary Shelly", 1818));
        books.add(new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954));
        bookList = new BookList();
        bookList.setBookList(books);
    }

    @Test
    public void shouldSeeListOfAllBooksWithColumnSeparators() {
        bookList.displayBookList();

        String outputBook1 = format("%-32s%-24s%-4d%n", "1984", "George Orwell", 1949);
        String outputBook2 = format("%-32s%-24s%-4d%n", "To Kill a Mockingbird", "Harper Lee", 1960);
        String outputBook3 = format("%-32s%-24s%-4d%n", "Frankenstein", "Mary Shelly", 1818);
        String outputBook4 = format("%-32s%-24s%-4d%n", "The Lord of the Rings", "J. R. R. Tolkien", 1954);

        assertThat(outContent.toString(), containsString(outputBook1));
        assertThat(outContent.toString(), containsString(outputBook2));
        assertThat(outContent.toString(), containsString(outputBook3));
        assertThat(outContent.toString(), containsString(outputBook4));
    }

    @Test
    public void shouldNotDisplayIfIsCheckout() {
        bookList.checkoutBook("1984");
        bookList.displayBookList();
        String checkoutBook = format("%-32s%-24s%-4d%n", "1984", "George Orwell", 1949);
        String notCheckoutBook = format("%-32s%-24s%-4d%n", "To Kill a Mockingbird", "Harper Lee", 1960);
        assertThat(outContent.toString(), not(containsString(checkoutBook)));
        assertThat(outContent.toString(), containsString(notCheckoutBook));
    }

    @Test
    public void shouldDisplayIfIsReturned() {
        bookList.checkoutBook("1984");
        bookList.returnBook("1984");
        bookList.displayBookList();
        String returnedBook = format("%-32s%-24s%-4d%n", "1984", "George Orwell", 1949);
        assertThat(outContent.toString(), containsString(returnedBook));
    }
}
