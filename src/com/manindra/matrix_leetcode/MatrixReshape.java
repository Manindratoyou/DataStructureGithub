package com.manindra.matrix_leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MatrixReshape { //solution 566

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 1, c = 4;

        int[][] result = matrixReshape(mat, r, c);
        for (int[] row : result) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;

        if (m * n != r * c)
            return mat; // Reshape not possible

        int[][] result = new int[r][c];

        for (int i = 0; i < m * n; i++) {
            result[i / c][i % c] = mat[i / n][i % n];
        }

        return result;
    }

    public static int[][] matrixReshapeStream(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) return mat;

        int[] flat = Arrays.stream(mat).flatMapToInt(Arrays::stream).toArray();

        return IntStream.range(0, r)
                .mapToObj(i -> Arrays.copyOfRange(flat, i * c, (i + 1) * c))
                .toArray(int[][]::new);
    }
}

