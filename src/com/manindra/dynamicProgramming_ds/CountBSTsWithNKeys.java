package com.manindra.dynamicProgramming_ds;

public class CountBSTsWithNKeys {

    static int countBSTs(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Number of BSTs with " + n + " keys: " + countBSTs(n));
    }
}

