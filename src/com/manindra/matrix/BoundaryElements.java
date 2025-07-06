package com.manindra.matrix;

public class BoundaryElements {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  2,  3,  4 },
                { 5,  6,  7,  8 },
                { 9, 10, 11, 12 },
                {13, 14, 15, 16}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Print top row
        for (int i = 0; i < cols; i++) {
            System.out.print(matrix[0][i] + " ");
        }

        // Print right column
        for (int i = 1; i < rows - 1; i++) {
            System.out.print(matrix[i][cols - 1] + " ");
        }

        // Print bottom row (if more than one row)
        if (rows > 1) {
            for (int i = cols - 1; i >= 0; i--) {
                System.out.print(matrix[rows - 1][i] + " ");
            }
        }

        // Print left column (if more than one column)
        if (cols > 1) {
            for (int i = rows - 2; i > 0; i--) {
                System.out.print(matrix[i][0] + " ");
            }
        }
    }
}

