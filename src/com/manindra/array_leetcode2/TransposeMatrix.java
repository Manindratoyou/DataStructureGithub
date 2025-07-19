package com.manindra.array_leetcode2;

public class TransposeMatrix { //solution 867

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] result = transpose(matrix);

        System.out.println("Transposed Matrix:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }

        return newMatrix;
    }
}
