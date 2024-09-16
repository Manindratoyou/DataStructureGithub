package com.manindra.pattern;

public class ZigzagPattern {

    public static void main(String[] args) {
        int n = 3; // Number of rows

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print("  "); // Print spaces
            }
            System.out.print("*");
            for (int j = 1; j <= 2 * (n - i) - 1; j++) {
                System.out.print("  "); // Print spaces
            }
            if (i != n) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

