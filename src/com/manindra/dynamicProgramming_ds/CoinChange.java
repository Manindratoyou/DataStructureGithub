package com.manindra.dynamicProgramming_ds;

public class CoinChange {

    public static void main(String[] args) {
        int[] coinDenominations = {1, 2, 3};
        int targetSum = 4;
        // Output: 4
        // Explanation: (1+1+1+1, 2+2, 1+3, 2+1+1)
        System.out.println(countWaysRecursive(coinDenominations, coinDenominations.length, targetSum));
        System.out.println(countWaysDP(coinDenominations, coinDenominations.length, targetSum));
    }

    static int countWaysRecursive(int[] coinDenominations, int numberOfCoins, int targetSum) {
        if (targetSum == 0)
            return 1;
        if (targetSum < 0)
            return 0;
        if (numberOfCoins <= 0)
            return 0;
        return countWaysRecursive(coinDenominations, numberOfCoins, targetSum - coinDenominations[numberOfCoins - 1]) +
                countWaysRecursive(coinDenominations, numberOfCoins - 1, targetSum);
    }

    // DP solution
    static int countWaysDP(int[] coinDenominations, int numberOfCoins, int targetSum) {
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;

        for (int i = 0; i < numberOfCoins; i++) {
            for (int j = coinDenominations[i]; j <= targetSum; j++) {
                dp[j] += dp[j - coinDenominations[i]];
            }
        }
        return dp[targetSum];
    }
}
