package com.manindra.string;

import java.util.regex.Pattern;

public class StringValidator {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        if (isNumeric(input)) {
            System.out.println("Entered string is numeric.");
        } else if (isAlphabetical(input)) {
            System.out.println("Entered string is alphabetical.");
        } else if (isAlphanumeric(input)) {
            System.out.println("Entered string is alphanumeric.");
        } else {
            System.out.println("Entered string contains special characters.");
        }
    }

    private static boolean isNumeric(String str) {
        return Pattern.matches("\\d+", str);
    }

    private static boolean isAlphabetical(String str) {
        return Pattern.matches("[a-zA-Z]+", str);
    }

    private static boolean isAlphanumeric(String str) {
        return Pattern.matches("[a-zA-Z0-9]+", str);
    }
}

