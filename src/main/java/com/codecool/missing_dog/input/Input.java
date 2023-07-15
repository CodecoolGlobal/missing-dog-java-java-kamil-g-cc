package com.codecool.missing_dog.input;

import java.util.Scanner;

public class Input {
    private Scanner scan;

    public Input() {
        initializeScanner();
    }

    public void initializeScanner() {
        scan = new Scanner(System.in);
        scan.useDelimiter(System.lineSeparator());
    }

    public String getInput(String message) {
        System.out.println(message);
        boolean validInput = false;
        String userInput = "";
        while (!validInput) {
            userInput = scan.next();
            if (!userInput.equals("")) {
                validInput = true;
            } else {
                System.out.println("Your input must contain at least one character. Enter again: ");
            }
        }
        return userInput.toUpperCase();
    }

    public int getIntInput(String title) {
        System.out.println(title);
        String userInput;
        int userInt = 1;
        boolean validInput = false;
        while (!validInput) {
            userInput = scan.next();
            if (!userInput.equals("") && userInput.matches("^[0-9]*$")) {
                validInput = true;
                userInt = Integer.parseInt(userInput);
            } else {
                System.out.println("Invalid input. Enter again: ");
            }
        }
        return userInt;
    }

    public int getIntInputInRange(int range) {
        String userInput;
        int userInt = 1;
        boolean validInput = false;
        while (!validInput) {
            userInput = scan.next();
            if (!userInput.equals("") && userInput.matches("^[0-9]*$") && userInt <= range) {
                validInput = true;
                userInt = Integer.parseInt(userInput);
            } else {
                System.out.println("Invalid input. Enter again: ");
            }
        }
        return userInt;
    }

    public void anyKey(String message) {
        System.out.println(message);
        scan.next();
    }

    public Boolean gatherBooleanInput(String message) {
        return Boolean.valueOf(getInput(message).toLowerCase());
    }
}
