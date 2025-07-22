package com.manindra.matrix_leetcode;

import java.util.*;

public class LuckyNumbersMatrix { //solution 1380

    public static void main(String[] args) {

        LuckyNumbersMatrix obj = new LuckyNumbersMatrix();
        int[][] matrix = {
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17}
        };
        System.out.println(obj.luckyNumbers(matrix)); // Output: [15]
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            // Find the min in the row
            int minColIndex = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] < matrix[i][minColIndex]) {
                    minColIndex = j;
                }
            }

            // Check if it's the max in that column
            int candidate = matrix[i][minColIndex];
            boolean isMaxInCol = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][minColIndex] > candidate) {
                    isMaxInCol = false;
                    break;
                }
            }

            if (isMaxInCol) {
                result.add(candidate);
            }
        }

        return result;
    }


}

