package com.manindra.matrix;

public class PrintBoundaryElement {

    static int R = 4, C = 4;

    public static void main(String[] args) {

        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        boundryTraversal(mat);
        System.out.println();
        boundaryTraversal(mat);


    }

    static void boundryTraversal(int[][] mat) {
        if (R == 1) {
            for (int i = 0; i < C; i++)
                System.out.print(mat[0][i] + " ");
        } else if (C == 1) {
            for (int i = 0; i < R; i++)
                System.out.print(mat[i][0] + " ");
        }
        for (int i = 0; i < C; i++)
            System.out.print(mat[0][i] + " ");
        for (int i = 1; i < R; i++)
            System.out.print(mat[i][C - 1] + " ");
        for (int i = C - 2; i >= 0; i--)
            System.out.print(mat[R - 1][i] + " ");
        for (int i = R - 2; i >= 1; i--)
            System.out.print(mat[i][0] + " ");
    }

    static void boundaryTraversal(int[][] mat) {
        int rows = mat.length;
        if (rows == 0) {
            return;
        }
        int cols = mat[0].length;
        if (cols == 0) {
            return;
        }

        if (rows == 1) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mat[0][j] + " ");
            }
            return;
        } else if (cols == 1) {
            for (int i = 0; i < rows; i++) {
                System.out.print(mat[i][0] + " ");
            }
            return;
        }

        // Top row
        for (int j = 0; j < cols; j++) {
            System.out.print(mat[0][j] + " ");
        }

        // Rightmost column
        for (int i = 1; i < rows; i++) {
            System.out.print(mat[i][cols - 1] + " ");
        }

        // Bottom row (in reverse order)
        for (int j = cols - 2; j >= 0; j--) {
            System.out.print(mat[rows - 1][j] + " ");
        }

        // Leftmost column (in reverse order, excluding the top-left element)
        for (int i = rows - 2; i >= 1; i--) {
            System.out.print(mat[i][0] + " ");
        }
    }
}
