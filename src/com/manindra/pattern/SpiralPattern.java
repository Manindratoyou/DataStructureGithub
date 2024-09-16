package com.manindra.pattern;

public class SpiralPattern {

    public static void main(String[] args) {
        int n = 5; // Number of rows and columns
        int[][] spiral = new int[n][n];
        int value = 1;

        int left = 0, right = n - 1, top = 0, bottom = n - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                spiral[top][i] = value++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                spiral[i][right] = value++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                spiral[bottom][i] = value++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                spiral[i][left] = value++;
            }
            left++;
        }

        // Print the spiral pattern
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(spiral[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

