package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public boolean isRunning;
    public MainMenu mainMenu;

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.initialise();
        app.run();
    }

    public void initialise() {
        this.isRunning = true;
        this.mainMenu = new MainMenu();

        String welcomeMsg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMsg);

        this.mainMenu.displayMainMenu();
    }

    public void run() {
        while (this.isRunning) {
            String input = getMenuInput();
            this.isRunning = this.mainMenu.processMenuInput(input);
        }
    }

    public String getMenuInput() {
        System.out.println("Select an option from the menu");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
