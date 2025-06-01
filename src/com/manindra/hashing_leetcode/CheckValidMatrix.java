package com.manindra.hashing_leetcode;

import java.util.*;

public class CheckValidMatrix { //solution 2133

    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < n; j++) {
                // Check row
                if (!rowSet.add(matrix[i][j]))
                    return false;

                // Check column
                if (!colSet.add(matrix[j][i]))
                    return false;
            }

            // Validate range
            if (rowSet.size() != n || colSet.size() != n)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CheckValidMatrix solver = new CheckValidMatrix();

        // Test Case 1
        int[][] grid1 = {
                {1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}
        };
        System.out.println("Test Case 1: " + solver.checkValid(grid1)); // true

        // Test Case 2
        int[][] grid2 = {
                {1, 1, 1},
                {1, 2, 3},
                {1, 2, 3}
        };
        System.out.println("Test Case 2: " + solver.checkValid(grid2)); // false

        // Test Case 3
        int[][] grid3 = {
                {2, 1},
                {1, 2}
        };
        System.out.println("Test Case 3: " + solver.checkValid(grid3)); // true

        // Test Case 4
        int[][] grid4 = {
                {1}
        };
        System.out.println("Test Case 4: " + solver.checkValid(grid4)); // true
    }
}

