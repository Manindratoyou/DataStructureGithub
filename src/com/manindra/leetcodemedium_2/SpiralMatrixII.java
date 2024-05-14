package com.manindra.leetcodemedium_2;

public class SpiralMatrixII { // solution 59

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        printMatrix(matrix);
    }

    static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;

        int num = 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                matrix[rowBegin][j] = num++;
            }
            rowBegin++;
            //Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                matrix[j][colEnd] = num++;
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                //Traverse left
                for (int j = colEnd; j >= colBegin; j--) {
                    matrix[rowEnd][j] = num++;
                }
            }
            rowEnd--;
            if (colBegin <= colEnd) {
                //Traverse Up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    matrix[j][colBegin] = num++;
                }
            }
            colBegin++;
        }

        return matrix;
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
