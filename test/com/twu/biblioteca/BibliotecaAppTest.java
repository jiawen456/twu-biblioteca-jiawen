package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BibliotecaApp app;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        app = new BibliotecaApp();
        app.initialise();
    }

    @Test
    public void shouldSeeWelcomeMessageOnStart() {
        String welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        assertThat(outContent.toString(), containsString(welcomeMsg));
    }

    @Test
    public void shouldSeeListOfMenuOptions() {
        String menuOption1 = "List of books";
        assertThat(outContent.toString(), containsString(menuOption1));
    }

    @Test
    public void shouldSeeListOfBooksWhenOptionSelected() {
        app.menuHandler("List of books");
        String listOfBooksMsg = "List of Library Books";
        assertThat(outContent.toString(), containsString(listOfBooksMsg));
    }

    @Test
    public void shouldSeeListOfAllBooks() {
        app.displayBookList();

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
        app.menuHandler("Invalid input");
        String invalidMsg = "Please select a valid option!";
        assertThat(outContent.toString(), containsString(invalidMsg));
    }

    @Test
    public void shouldNotExitWhenQuitOptionNotSelected() {
        app.menuHandler("List of books");
        assertThat(app.isRunning, is(true));
    }

    @Test
    public void shouldExitWhenQuitOptionSelected() {
        app.menuHandler("Quit");
        assertThat(app.isRunning, is(false));
    }

}