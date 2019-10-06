package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
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
    public void shouldNotDisplayBookAfterCheckoutOptionSelected() {
        String title = "1984";
        menu.bookList.checkoutBook(title);
        menu.displayMainMenu();
        assertThat(outContent.toString(), not(containsString(title)));
    }
}
