package com.manindra.hashing_leetcode;

import java.util.*;

public class EqualRowAndColumnPairs { //solution 2352

    public static void main(String[] args) {
        int[][] grid1 = {
                {3, 2, 1},
                {1, 7, 6},
                {2, 7, 7}
        };
        System.out.println(equalPairs(grid1)); // Output: 1

        int[][] grid2 = {
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        };
        System.out.println(equalPairs(grid2)); // Output: 3
    }

    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();

        // Store each row as a string in the map
        for (int i = 0; i < n; i++) {
            String key = Arrays.toString(grid[i]);
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }

        int count = 0;

        // Build each column as string and check in rowMap
        for (int col = 0; col < n; col++) {
            int[] colArr = new int[n];
            for (int row = 0; row < n; row++) {
                colArr[row] = grid[row][col];
            }
            String colKey = Arrays.toString(colArr);
            count += rowMap.getOrDefault(colKey, 0);
        }

        return count;
    }

}

