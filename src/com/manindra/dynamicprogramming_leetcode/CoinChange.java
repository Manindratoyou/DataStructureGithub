package com.manindra.dynamicprogramming_leetcode;

import java.util.Arrays;

// Important problem: Coin Change (LeetCode 322)
public class CoinChange {

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};//int[] coins = {1, 5, 6,9}; //amount 11
        int amount = 11;
        // Expected output: 3 (Explanation: 11 = 5 + 5 + 1)
        System.out.println(getAmount(coins, amount));
        System.out.println(coinChangeSolutionTwo(coins, amount));
        System.out.println(coinChangeSolutionThree(coins, amount));
    }

    // Solution 1: Some test cases are failing
    static int getAmount(int[] coins, int amount) {
        int count = 0;
        // Start from the largest denomination
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount >= coins[i]) {
                count += amount / coins[i]; // Use as many of this denomination as possible
                amount %= coins[i]; // Reduce the amount by the used value
            }
        }
        // If the amount is not zero here, it means it's not possible to form the exact amount with given denominations
        if (amount != 0)
            return -1;

        return count;
    }

    // Solution 2: Dynamic Programming approach
    // Time Complexity: O(amount * n), where n is the number of coins
    // Auxiliary Space: O(amount)
    static int coinChangeSolutionTwo(int[] coins, int amount) {
        // Check edge case
        if (amount < 1) return 0;

        // Create DP array
        int[] minCoinsDP = new int[amount + 1];

        // Initialize DP array with maximum value
        for (int i = 1; i <= amount; i++) {
            minCoinsDP[i] = Integer.MAX_VALUE;
            // Try each coin
            for (int coin : coins) {
                // Check if coin can be used to form the amount
                if (coin <= i && minCoinsDP[i - coin] != Integer.MAX_VALUE) {
                    minCoinsDP[i] = Math.min(minCoinsDP[i], 1 + minCoinsDP[i - coin]);
                }
            }
        }

        // If the amount cannot be formed with the given coins, return -1
        return minCoinsDP[amount] == Integer.MAX_VALUE ? -1 : minCoinsDP[amount];
    }

    // Solution 3: Another Dynamic Programming approach
    // Time Complexity: O(amount * n), where n is the number of coins
    // Auxiliary Space: O(amount)
    static int coinChangeSolutionThree(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];

        // Initialize DP array with a value larger than the amount
        Arrays.fill(dp, max);
        dp[0] = 0;

        // Build the DP array
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If the amount cannot be formed with the given coins, return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
