package com.manindra.pattern;

public class HollowDiamondPattern {

    public static void main(String[] args) {
        int n = 5; // Number of rows (half of the diamond)

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" "); // Print spaces
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                if (k == 1 || k == 2 * i - 1) {
                    System.out.print("*"); // Print stars at edges
                } else {
                    System.out.print(" "); // Print spaces inside
                }
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" "); // Print spaces
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                if (k == 1 || k == 2 * i - 1) {
                    System.out.print("*"); // Print stars at edges
                } else {
                    System.out.print(" "); // Print spaces inside
                }
            }
            System.out.println();
        }
    }
}

