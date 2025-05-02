package com.manindra.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnakePatternMatrix2 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        printSnakePattern(matrix);
        System.out.println();
        System.out.println("===============");
        List<Integer> result=snakePattern(matrix);
        System.out.println(result);

    }

    static void printSnakePattern(int[][] matrix) {
        int rows = matrix.length;

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                // Left to Right
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
            } else {
                // Right to Left
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }

    static List<Integer> snakePattern(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                Arrays.stream(matrix[i]).forEach(result::add);
            } else {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }
}
