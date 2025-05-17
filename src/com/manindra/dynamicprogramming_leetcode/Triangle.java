package com.manindra.dynamicprogramming_leetcode;

import java.util.List;

public class Triangle { //solution 120

    public static void main(String[] args) {
        // Example usage
        Triangle triangle = new Triangle();
        List<List<Integer>> triangleList = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );

        int minimumTotal = triangle.minimumTotalSolutionOne(triangleList);
        System.out.println("Minimum total: " + minimumTotal);
    }

    int minimumTotalSolutionOne(List<List<Integer>> triangle) {

        int height = triangle.size();
        int[][] dp = new int[height + 1][height + 1];

        for (int level = height - 1; level >= 0; level--) {

            for (int i = 0; i <= level; i++) {

                // Add the minimum amongst 2 adjacent elements
                // from bottom level
                dp[level][i] = triangle.get(level).get(i) +
                        Math.min(dp[level + 1][i], dp[level + 1][i + 1]);
            }

        }

        return dp[0][0];
    }

    Integer memo[][];
    public int minimumTotalSolutionTwo(List<List<Integer>> triangle) {

        int len = triangle.size();
        memo = new Integer[len][len];
        return FindMinimum(triangle, 0 , 0, len);

    }

    private int FindMinimum(List<List<Integer>> triangle, int row, int col, int len){

        if(row == len - 1)
            return triangle.get(row).get(col);

        if(memo[row][col] != null)
            return memo[row][col];

        int down = triangle.get(row).get(col) + FindMinimum(triangle, row + 1, col, len);
        int downPlusOne = triangle.get(row).get(col) + FindMinimum(triangle, row + 1, col + 1, len);

        return memo[row][col] = Math.min(down, downPlusOne);
    }

}
