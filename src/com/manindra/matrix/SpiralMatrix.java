package com.manindra.matrix;

import java.util.Arrays;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        // Print original matrix
        System.out.println("Input Matrix:");
        Arrays.stream(mat).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.print(element + " "));
            System.out.println();
        });

        System.out.println("\nSpiral Order:");
        printSpiral(mat);
    }

    static void printSpiral(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            System.out.println("Matrix is empty.");
            return;
        }

        int R = mat.length;
        int C = mat[0].length;

        int top = 0, left = 0, bottom = R - 1, right = C - 1;

        while (top <= bottom && left <= right) {

            // Top row → direction
            for (int i = left; i <= right; i++)
                System.out.print(mat[top][i] + " ");
            top++;

            // Right column ↓ direction
            for (int i = top; i <= bottom; i++)
                System.out.print(mat[i][right] + " ");
            right--;

            // Bottom row ← direction (if still in bounds)
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    System.out.print(mat[bottom][i] + " ");
                bottom--;
            }

            // Left column ↑ direction (if still in bounds)
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    System.out.print(mat[i][left] + " ");
                left++;
            }
        }
    }
}
