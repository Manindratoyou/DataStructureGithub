package com.manindra.pattern;

public class HollowRhombusPattern {
    public static void main(String[] args) {
        int n = 5; // Number of rows

        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print stars for the first and last row
            if (i == 1 || i == n) {
                for (int k = 1; k <= n; k++) {
                    System.out.print("*");
                }
            } else {
                // Print stars with spaces in between
                System.out.print("*");
                for (int k = 1; k <= n - 2; k++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

