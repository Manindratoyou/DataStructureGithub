package com.manindra.dynamicprogramming_leetcode;

public class CoinChange2 { //solution 518

    public static void main(String[] args) {
        // Test Case 1
        int amount1 = 5;
        int[] coins1 = {1, 2, 5};
        System.out.println("Ways to make amount " + amount1 + " = " + change(amount1, coins1));
        // Output: 4

        // Test Case 2
        int amount2 = 3;
        int[] coins2 = {2};
        System.out.println("Ways to make amount " + amount2 + " = " + change(amount2, coins2));
        // Output: 0

        // Test Case 3
        int amount3 = 10;
        int[] coins3 = {10};
        System.out.println("Ways to make amount " + amount3 + " = " + change(amount3, coins3));
        // Output: 1

        // Test Case 4
        int amount4 = 0;
        int[] coins4 = {1, 2, 3};
        System.out.println("Ways to make amount " + amount4 + " = " + change(amount4, coins4));
        // Output: 1 (only one way: use no coins)
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // Base case: one way to make amount 0

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

}

