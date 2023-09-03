package com.manindra.hackerrank;

import java.util.Scanner;

public class HackerRankJavaSolutionTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read an integer
        int intValue = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Read a double
        double doubleValue = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        // Read a string
        String stringValue = scanner.nextLine();

        // Print the values
        System.out.println("String: " + stringValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("Int: " + intValue);

        scanner.close();
    }
}

