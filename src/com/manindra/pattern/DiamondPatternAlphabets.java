package com.manindra.pattern;

public class DiamondPatternAlphabets {

    public static void main(String[] args) {
        char lastChar = 'E'; // Last alphabet
        int n = lastChar - 'A' + 1; // Number of rows (half of the diamond)
        char currentChar;

        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print characters in increasing order
            for (int k = 1; k <= 2 * i - 1; k++) {
                currentChar = (char) ('A' + k - 1);
                System.out.print(currentChar);
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print characters in decreasing order
            for (int k = 1; k <= 2 * i - 1; k++) {
                currentChar = (char) ('A' + k - 1);
                System.out.print(currentChar);
            }
            System.out.println();
        }
    }
}

