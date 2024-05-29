package com.manindra.leetcodemedium_2;

import java.util.Arrays;

public class SetMatrixZeroes { // solution 73

    public static void main(String[] args) {
        SetMatrixZeroes obj = new SetMatrixZeroes();
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        Arrays.stream(matrix).forEach(row->{Arrays.stream(row).
                forEach(element-> System.out.print(element+" "));
            System.out.println();});
        //obj.setZeroes(matrix);
        System.out.println("After Operation");
        setZeroesSolutionTwo(matrix);

        // Printing the matrix to verify the result
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Arrays to mark the rows and columns that should be zero
        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];

        // First pass: mark rows and columns that need to be zeroed
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // Second pass: set matrix elements to zero if marked
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void setZeroesSolutionTwo(int[][] matrix) { //space optimized
        boolean firstRow = false, firstCol = false;

        // Set markers in first row and first column
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }

        // Replace inner matrix
        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        // Last remaining checks
        if (firstRow)
            for (int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;

        if (firstCol)
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
    }

}

