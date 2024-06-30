package com.manindra.dynamicProgramming_ds;

public class KnapSackProblem {

    public static void main(String[] args) {
        int[] values = {10, 40, 30, 50};
        int[] weights = {5, 4, 6, 3};
        int maxWeight = 10;
        int numberOfItems = 4;

        System.out.println(knapSack(maxWeight, weights, values, numberOfItems));
        System.out.println(knapSackDP(maxWeight, weights, values, numberOfItems));
    }

    static int knapSack(int maxWeight, int[] weights, int[] values, int numberOfItems) { // Recursive
        if (numberOfItems == 0 || maxWeight == 0) {
            return 0;
        }
        if (weights[numberOfItems - 1] > maxWeight) {
            return knapSack(maxWeight, weights, values, numberOfItems - 1);
        } else {
            return Math.max(
                    values[numberOfItems - 1] + knapSack(maxWeight - weights[numberOfItems - 1], weights, values, numberOfItems - 1),
                    knapSack(maxWeight, weights, values, numberOfItems - 1)
            );
        }
    }

    static int knapSackDP(int maxWeight, int[] weights, int[] values, int numberOfItems) { // Dynamic Programming
        int[][] dp = new int[numberOfItems + 1][maxWeight + 1];

        for (int i = 0; i <= numberOfItems; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[numberOfItems][maxWeight];
    }
}
