package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        BibliotecaApp app = new BibliotecaApp();
        app.initialise();
    }

    @Test
    public void shouldSeeWelcomeMessageOnStart() {
        String welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        assertThat(outContent.toString(), containsString(welcomeMsg));
    }

    @Test
    public void shouldSeeListOfMenuOptionsOnStart() {
        String menuOption1 = "List of books";
        assertThat(outContent.toString(), containsString(menuOption1));
    }


}