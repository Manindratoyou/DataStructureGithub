package com.manindra.leetcodeMedium;

public class Solution48 { //RotateImage

    public static void main(String[] args) {

        int [] [] arr={{1,2,3},
                {4,5,6},
                {7,8,9}};
        rotate(arr);
        for (int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < (n + 1) / 2; i ++) {

            for (int j = 0; j < n / 2; j++) {
                // Start 4 way swaps
                // temp = bottom left
                int temp = matrix[n - 1 - j][i];

                // bottom left = bottom right
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];

                // bottom right = top right
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];

                // top right = top left
                matrix[j][n - 1 - i] = matrix[i][j];

                // top left = temp
                matrix[i][j] = temp;
            }
        }
    }

    static int[][] rotate2(int[][] matrix) {

        // Transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }

        return matrix;
    }
}
