package com.manindra.pattern;

public class HourglassPattern {

    public static void main(String[] args) {
        int n = 4; // Number of rows

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print("  "); // Print spaces
            }
            for (int k = i; k <= n; k++) {
                System.out.print(k + " "); // Print numbers
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                System.out.print("  "); // Print spaces
            }
            for (int k = i; k <= n; k++) {
                System.out.print(k + " "); // Print numbers
            }
            System.out.println();
        }
    }
}

