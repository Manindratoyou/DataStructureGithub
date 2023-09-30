package com.manindra.pattern;

public class PascalsTriangle {

    public static void main(String[] args) {
        int n = 5; // Number of rows

        for (int i = 0; i < n; i++) {
            int number = 1;
            for (int j = 0; j < n - i; j++) {
                System.out.print("  "); // Print spaces
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(number + "   ");
                number = number * (i - k) / (k + 1);
            }
            System.out.println();
        }
    }
}

