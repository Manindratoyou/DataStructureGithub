package com.manindra.pattern;

public class HollowPyramid {

    public static void main(String[] args) {
        int n = 5; // Number of rows

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  "); // Print spaces
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                if (k == 1 || k == 2 * i - 1 || i == n) {
                    System.out.print("* "); // Print stars
                } else {
                    System.out.print("  "); // Print spaces inside
                }
            }
            System.out.println();
        }
    }
}

