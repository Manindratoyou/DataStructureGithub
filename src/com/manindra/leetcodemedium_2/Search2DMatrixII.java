package com.manindra.leetcodemedium_2;

public class Search2DMatrixII { //solution 240

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  4,  7, 11, 15},
                {2,  5,  8, 12, 19},
                {3,  6,  9, 16, 22},
                {10,13, 14,17, 24},
                {18,21, 23,26, 30}
        };
        int target = 5;
        System.out.println("Found target? " + searchMatrix(matrix, target)); // true
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0, col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // move left
            } else {
                row++; // move down
            }
        }
        return false;
    }
}

