package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class MainMenuTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private MainMenu menu;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        menu = new MainMenu();
    }

    @Test
    public void shouldSeeListOfBooksWhenOptionSelected() {
        menu.processMenuInput("List of books");

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
    public void shouldBeNotifiedWhenInvalidOptionSelected() {
        menu.processMenuInput("Invalid input");
        String invalidMsg = "Please select a valid option!";
        assertThat(outContent.toString(), containsString(invalidMsg));
    }

    @Test
    public void shouldNotExitWhenQuitOptionNotSelected() {
        boolean isRunning = menu.processMenuInput("List of books");
        assertThat(isRunning, is(true));
    }

    @Test
    public void shouldExitWhenQuitOptionSelected() {
        boolean isRunning = menu.processMenuInput("Quit");
        assertThat(isRunning, is(false));
    }

    @Test
    public void shouldNotDisplayBookAfterSuccessfulCheckout() {
        String title = "Frankenstein";
        menu.bookList.checkoutBook(title);
        menu.processMenuInput("List of books");
        assertThat(outContent.toString(), not(containsString(title)));
    }

    @Test
    public void shouldDisplaySuccessMessageAfterSuccessfulCheckout() {
        String title = "1984";
        InputStream in = new ByteArrayInputStream(title.getBytes());
        System.setIn(in);
        menu.processCheckoutBook();
        String successMsg = "Thank you! Enjoy the book";
        assertThat(outContent.toString(), containsString(successMsg));
    }

    @Test
    public void shouldDisplayUnsuccessfulMessageAfterUnsuccessfulCheckout() {
        String title = "1989";
        InputStream in = new ByteArrayInputStream(title.getBytes());
        System.setIn(in);
        menu.processCheckoutBook();
        String successMsg = "Sorry, that book is not available";
        assertThat(outContent.toString(), containsString(successMsg));
    }

    @Test
    public void shouldDisplayBookAfterSuccessfulReturn() {
        String title = "Frankenstein";
        menu.bookList.checkoutBook(title);
        menu.bookList.returnBook(title);
        menu.processMenuInput("List of books");
        assertThat(outContent.toString(), containsString(title));
    }

    @Test
    public void shouldDisplaySuccessMessageAfterSuccessfulReturn() {
        String title = "1984";
        menu.bookList.checkoutBook(title);
        InputStream in = new ByteArrayInputStream(title.getBytes());
        System.setIn(in);
        menu.processReturnBook();
        String successMsg = "Thank you for returning the book";
        assertThat(outContent.toString(), containsString(successMsg));
    }

    @Test
    public void shouldDisplayUnsuccessfulMessageAfterUnsuccessfulReturn() {
        String title = "1989";
        InputStream in = new ByteArrayInputStream(title.getBytes());
        System.setIn(in);
        menu.processReturnBook();
        String successMsg = "That is not a valid book to return.";
        assertThat(outContent.toString(), containsString(successMsg));
    }
}
