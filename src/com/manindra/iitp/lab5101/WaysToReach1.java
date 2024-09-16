package com.manindra.iitp.lab5101;

public class WaysToReach1 {

    public static void main(String[] args) {
        // Test cases
        int[] testCases = {1, 2, 3, 4, 5, 10};  // Add or modify test cases as needed

        for (int n : testCases) {
            System.out.print("Ways to reach step " + n + ": ");
            System.out.println(findWays(n));
        }
    }

    private static int findWays(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
