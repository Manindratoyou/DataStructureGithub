package com.manindra.graph_leetcode;

import java.util.Arrays;

public class RottingOrangesDFS { //Solution 994

    public static void main(String[] args) {
        RottingOrangesDFS solution = new RottingOrangesDFS();

        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println("Test 1 Output: " + solution.orangesRotting(grid1)); // Expected: 4

        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println("Test 2 Output: " + solution.orangesRotting(grid2)); // Expected: -1

        int[][] grid3 = {
                {0, 2}
        };
        System.out.println("Test 3 Output: " + solution.orangesRotting(grid3)); // Expected: 0
    }

    int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length, cols = grid[0].length;
        int[][] time = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            Arrays.fill(time[i], Integer.MAX_VALUE);

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == 2)
                    dfs(grid, time, i, j, 0);

        int timeRequired = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == 1) {
                    if (time[i][j] == Integer.MAX_VALUE) return -1;
                    timeRequired = Math.max(timeRequired, time[i][j]);
                }

        return timeRequired;
    }

    private void dfs(int[][] grid, int[][] time, int i, int j, int currentTime) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || grid[i][j] == 0 || currentTime >= time[i][j]) return;

        time[i][j] = currentTime;
        dfs(grid, time, i - 1, j, currentTime + 1);
        dfs(grid, time, i + 1, j, currentTime + 1);
        dfs(grid, time, i, j - 1, currentTime + 1);
        dfs(grid, time, i, j + 1, currentTime + 1);
    }
}
