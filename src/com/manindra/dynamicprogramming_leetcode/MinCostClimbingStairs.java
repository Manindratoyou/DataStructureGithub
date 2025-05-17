package com.manindra.dynamicprogramming_leetcode;

class MinCostClimbingStairs { //solution 746

    public static void main(String[] args) {
        // Test cases
        int[] cost1 = {10, 15, 20};
        System.out.println("Minimum cost to climb: " + minCostClimbingStairs(cost1)); // Expected: 15

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Minimum cost to climb: " + minCostClimbingStairs(cost2)); // Expected: 6

        int[] cost3 = {4,8,15,16,23,42};
        System.out.println("Minimum cost to climb: " + minCostClimbingStairs(cost3));
    }

    static int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] minCost = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            minCost[i] =
                    Math.min(
                            (cost[i - 1] + minCost[i - 1]),
                            (cost[i - 2] + minCost[i - 2])
                    );
        }

        return minCost[n];
    }
}
