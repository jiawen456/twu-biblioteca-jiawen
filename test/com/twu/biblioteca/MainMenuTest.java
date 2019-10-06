package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

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
        String listOfBooksMsg = "List of Library Books";
        assertThat(outContent.toString(), containsString(listOfBooksMsg));
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
    
}
