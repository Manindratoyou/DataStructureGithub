package com.manindra.hackerrank_2;

import java.util.*;

public class FlippingTheMatrix {

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int topLeft = matrix.get(i).get(j);
                int topRight = matrix.get(i).get(2 * n - 1 - j);
                int bottomLeft = matrix.get(2 * n - 1 - i).get(j);
                int bottomRight = matrix.get(2 * n - 1 - i).get(2 * n - 1 - j);

                sum += Math.max(Math.max(topLeft, topRight), Math.max(bottomLeft, bottomRight));
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(112, 42, 83, 119),
                Arrays.asList(56, 125, 56, 49),
                Arrays.asList(15, 78, 101, 43),
                Arrays.asList(62, 98, 114, 108)
        );

        System.out.println(flippingMatrix(matrix));  // Output: 414
    }
}

