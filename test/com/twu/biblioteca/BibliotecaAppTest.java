package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BibliotecaApp app;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        app = new BibliotecaApp();
    }

    @Test
    public void shouldSeeWelcomeMessageOnStart() {
        app.start();

        String welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        assertThat(outContent.toString(), containsString(welcomeMsg));
    }

    @Test
    public void shouldSeeListOfAllBooks() {
        FakeBookList bookList = new FakeBookList();
        app.displayBookList(bookList);

        String output = "1984\nTo Kill a Mockingbird\nFrankenstein\nThe Lord of the Rings";
        assertThat(outContent.toString(), containsString(output));
    }

}
