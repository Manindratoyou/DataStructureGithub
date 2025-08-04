package com.manindra.array_leetcode2;

public class CountNegativesMatrix { //solution 1351

    public static void main(String[] args) {
        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println(countNegatives(grid)); // Output: 8
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countNegatives2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int row = 0, col = n - 1;
        int count = 0;

        while (row < m && col >= 0) {
            if (grid[row][col] < 0) {
                count += (m - row); // all elements below are also negative
                col--; // move left
            } else {
                row++; // move down
            }
        }

        return count;
    }

}

