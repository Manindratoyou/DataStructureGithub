package com.manindra.leetcodemedium_2;

public class TriangleArrayRep { // solution 120

    public static void main(String[] args) {
        // Example usage
        TriangleArrayRep triangle = new TriangleArrayRep();
        int[][] triangleArray = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };

        int minimumTotal = triangle.minimumTotalSolutionOne(triangleArray);
        System.out.println("Minimum total (Solution One): " + minimumTotal);

        minimumTotal = triangle.minimumTotalSolutionTwo(triangleArray);
        System.out.println("Minimum total (Solution Two): " + minimumTotal);
    }

    int minimumTotalSolutionOne(int[][] triangle) {
        int height = triangle.length;
        int[][] dp = new int[height + 1][height + 1];

        for (int level = height - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {
                // Add the minimum amongst 2 adjacent elements from the bottom level
                dp[level][i] = triangle[level][i] +
                        Math.min(dp[level + 1][i], dp[level + 1][i + 1]);
            }
        }

        return dp[0][0];
    }

    Integer[][] memo;

    public int minimumTotalSolutionTwo(int[][] triangle) {
        int height = triangle.length;
        memo = new Integer[height][height];
        return findMinimum(triangle, 0, 0, height);
    }

    private int findMinimum(int[][] triangle, int row, int col, int height) {
        if (row == height - 1) {
            return triangle[row][col];
        }

        if (memo[row][col] != null) {
            return memo[row][col];
        }

        int down = triangle[row][col] + findMinimum(triangle, row + 1, col, height);
        int downPlusOne = triangle[row][col] + findMinimum(triangle, row + 1, col + 1, height);

        return memo[row][col] = Math.min(down, downPlusOne);
    }
}

