package com.manindra.matrix;

import java.util.Arrays;

public class TransposeMatrix {

    static int n = 4;

    public static void main(String[] args) {

        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        //transposeSolOne(mat);
        transposeSolTwo(mat);
        Arrays.stream(mat).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.print(element + " "));
            System.out.println();
        });

        System.out.println("Second Example");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}};
        int [][] result=transpose(matrix);
        Arrays.stream(result).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.print(element + " "));
            System.out.println();
        });
    }

    static void transposeSolOne(int[][] mat) {
        int[][] tempMat = new int[n][n];
        //copy mat[][] to temp[][]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempMat[i][j] = mat[j][i];
            }
        }
        //copy temp[][] to mat
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                mat[i][j] = tempMat[i][j];
        }
    }

    static void transposeSolTwo(int[][] mat) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                swap(mat, i, j);
        }
    }

    static void swap(int[][] mat, int i, int j) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

    static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}
