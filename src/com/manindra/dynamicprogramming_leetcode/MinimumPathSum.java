package com.manindra.dynamicprogramming_leetcode;

public class MinimumPathSum { //Solution 64

    public static void main(String[] args) {

       int [] []  grid = {
               {1, 3, 1},
               {1, 5, 1},
               {4, 2, 1} };
        System.out.println(minPathSum(grid));

       // Output: 7  // 1 → 3 → 1 → 1 → 1

    }

    static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // Fill first row
        for (int j = 1; j < n; j++)
            dp[0][j] = dp[0][j - 1] + grid[0][j];

        // Fill first column
        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        // Fill rest of the dp matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    //Space Optimization (1D DP)
    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];

        dp[0] = grid[0][0];

        for (int j = 1; j < n; j++)
            dp[j] = dp[j - 1] + grid[0][j];

        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0]; // First column update
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }

        return dp[n - 1];
    }
}

