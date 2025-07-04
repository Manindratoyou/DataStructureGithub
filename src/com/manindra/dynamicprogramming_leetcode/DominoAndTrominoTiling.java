package com.manindra.dynamicprogramming_leetcode;

public class DominoAndTrominoTiling { //solution 790

    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTilings(n));  // Output: 5
    }

    public static int numTilings(int n) {
        int MOD = 1_000_000_007;

        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }

        return (int) dp[n];
    }
    public static int numTilings2(int n) {
        int MOD = 1_000_000_007;

        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long a = 1, b = 1, c = 2, curr = 0;

        for (int i = 3; i <= n; i++) {
            curr = (2 * c + a) % MOD;
            a = b;
            b = c;
            c = curr;
        }

        return (int) curr;
    }
}

