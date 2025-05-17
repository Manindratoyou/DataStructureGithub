package com.manindra.dynamicprogramming_leetcode;

import java.util.Arrays;
import java.util.List;

public class CoinChangeComparison {

    public static void main(String[] args) {
        // Example for HackerRank Coin Change
        int n1 = 10;
        List<Long> coins1 = Arrays.asList(2L, 5L, 3L, 6L);
        System.out.println("HackerRank Coin Change (Number of Ways): " + countWays(n1, coins1));

        // Example for LeetCode 322 Coin Change
        int n2 = 11;
        int[] coins2 = {1, 2, 5};
        System.out.println("LeetCode Coin Change (Minimum Coins): " + minCoins(n2, coins2));
    }

    // HackerRank Coin Change: Count number of ways
    public static long countWays(int n, List<Long> coins) {
        long[] dp = new long[n + 1];
        dp[0] = 1; // Base case: 1 way to make amount 0 (use no coins)

        for (long coin : coins) {
            for (int j = (int) coin; j <= n; j++) {
                dp[j] += dp[j - (int) coin];
            }
        }

        return dp[n];
    }

    // LeetCode 322 Coin Change: Minimize number of coins
    public static int minCoins(int n, int[] coins) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: 0 coins needed to make amount 0

        for (int coin : coins) {
            for (int j = coin; j <= n; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}

