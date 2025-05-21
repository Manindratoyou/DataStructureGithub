package com.manindra.dynamicprogramming_leetcode;

import java.util.Arrays;

public class Matrix01 { //solution 542

    public static void main(String[] args) {
        // Test Case 1
        int[][] mat1 = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        System.out.println("Test Case 1:");
        printMatrix(updateMatrix(mat1));

        // Test Case 2
        int[][] mat2 = {
                {0, 1, 1},
                {1, 1, 1},
                {1, 1, 0}
        };
        System.out.println("Test Case 2:");
        printMatrix(updateMatrix(mat2));

        // Test Case 3 - all 1s except one 0 in corner
        int[][] mat3 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 0}
        };
        System.out.println("Test Case 3:");
        printMatrix(updateMatrix(mat3));

        // Test Case 4 - all 0s
        int[][] mat4 = {
                {0, 0},
                {0, 0}
        };
        System.out.println("Test Case 4:");
        printMatrix(updateMatrix(mat4));

        // Test Case 5 - single row
        int[][] mat5 = {
                {1, 0, 1, 1, 0}
        };
        System.out.println("Test Case 5:");
        printMatrix(updateMatrix(mat5));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dp = new int[rows][cols];
        int MAX = rows + cols;

        // First pass: top-left to bottom-right
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int top = (i > 0) ? dp[i - 1][j] : MAX;
                    int left = (j > 0) ? dp[i][j - 1] : MAX;
                    dp[i][j] = Math.min(top, left) + 1;
                }
            }
        }

        // Second pass: bottom-right to top-left
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    int bottom = (i < rows - 1) ? dp[i + 1][j] : MAX;
                    int right = (j < cols - 1) ? dp[i][j + 1] : MAX;
                    dp[i][j] = Math.min(dp[i][j], Math.min(bottom, right) + 1);
                }
            }
        }

        return dp;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}


