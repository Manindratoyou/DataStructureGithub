package com.manindra.dynamicProgramming_ds;

public class CoinChangeCombinations {

    public static void main(String[] args) {
        int[] coins1 = {1, 2, 3};
        int target1 = 4;
        System.out.println("Output 1: " + countCombinations(coins1, target1));  // Output: 4

        int[] coins2 = {2, 5, 3, 6};
        int target2 = 10;
        System.out.println("Output 2: " + countCombinations(coins2, target2));  // Output: 5
    }

    public static int countCombinations(int[] coins, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: 1 way to make sum 0 (no coins)

        for (int coin : coins) {
            for (int i = coin; i <= target; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[target];
    }
}

