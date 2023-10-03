package com.manindra.pattern;

public class DiamondPattern {

    public static void main(String[] args) {
        int n = 5; // Number of rows (half of the diamond)

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" "); // Print spaces
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*"); // Print stars
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" "); // Print spaces
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*"); // Print stars
            }
            System.out.println();
        }
    }
}

