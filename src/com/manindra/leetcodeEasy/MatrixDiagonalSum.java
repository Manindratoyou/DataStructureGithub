package com.manindra.leetcodeEasy;

public class MatrixDiagonalSum { //solution 1572

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        System.out.println("Matrix 1 diagonal sum: " + diagonalSum(matrix1)); // Expected output: 25
        //System.out.println("Matrix 2 diagonal sum: " + diagonalSum(matrix2)); // Expected output: 8
    }

    static int diagonalSum(int[][] mat) {

        int sum = 0;
        int n = mat.length;

        // Get the sum of both diagonals
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - i - 1];
        }

        // If the matrix is odd
        // Subtract the duplicate element
        if (n % 2 != 0) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
    }
}
