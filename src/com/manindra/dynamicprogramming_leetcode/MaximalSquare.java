package com.manindra.dynamicprogramming_leetcode;

public class MaximalSquare { //solution 221

    public static void main(String[] args) {
        // Test case 1
        char[][] matrix1 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println("Max square area (matrix1): " + maximalSquare(matrix1)); // Output: 4

        // Test case 2
        char[][] matrix2 = {
                {'0', '1'},
                {'1', '0'}
        };
        System.out.println("Max square area (matrix2): " + maximalSquare(matrix2)); // Output: 1

        // Test case 3
        char[][] matrix3 = {
                {'0'}
        };
        System.out.println("Max square area (matrix3): " + maximalSquare(matrix3)); // Output: 0

        // Test case 4
        char[][] matrix4 = {
                {'1', '1'},
                {'1', '1'}
        };
        System.out.println("Max square area (matrix4): " + maximalSquare(matrix4)); // Output: 4
    }

    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);

                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
}

