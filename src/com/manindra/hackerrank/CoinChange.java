package com.manindra.hackerrank;

import java.util.Arrays;
import java.util.List;

/*
The 5 ways to make 10 are from 2,5,3,6
2, 2, 2, 2, 2
2, 2, 3, 3
2, 2, 6
5, 5
5, 3, 2
 */
public class CoinChange {

    public static void main(String[] args) {
        int n = 10;
        List<Long> coins = Arrays.asList(2L, 5L, 3L, 6L);

        long ways = getWays(n, coins);
        System.out.println("Number of ways: " + ways); // Output: 5
    }

    public static long getWays(int n, List<Long> c) {
        long[] coins = c.stream().mapToLong(Long::longValue).toArray();
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (long coin : coins) {
            for (int j = (int) coin; j <= n; j++) {
                dp[j] += dp[j - (int) coin];
            }
        }

        return dp[n];
    }
}

