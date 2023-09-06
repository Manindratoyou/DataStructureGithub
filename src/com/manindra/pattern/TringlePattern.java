package com.manindra.pattern;

public class TringlePattern {

    public static void main(String[] args) {

        int n = 5; // Number of rows in the triangle

        // Loop to iterate through each row
        for (int i = 1; i <= n; i++) {
            // Loop to print spaces before the asterisks
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Loop to print asterisks in the current row
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }

            // Move to the next line after printing each row
            System.out.println();
        }
    }
}
