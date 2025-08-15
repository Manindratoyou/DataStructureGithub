package com.manindra.dynamicProgramming_ds;

public class Maxcuts {

    public static void main(String[] args) {
        int n = 5, a = 1, b = 2, c = 3;

        System.out.println(maxCutsRecursion(n, a, b, c));
        System.out.println(maxCuts(n, a, b, c));


    }

    static int maxCutsRecursion(int n, int a, int b, int c) {

        if (n < 0)
            return -1;
        if (n == 0)
            return 0;
        int result = Math.max(maxCutsRecursion(n - a, a, b, c),
                Math.max(maxCutsRecursion(n - b, a, b, c), maxCutsRecursion(n - c, a, b, c)));

        if (result == -1)
            return result;
        return result + 1;
    }

    static int maxCuts(int n, int a, int b, int c) {

        int dp[] = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = -1;

            if (i - a >= 0) dp[i] = Math.max(dp[i], dp[i - a]);

            if (i - b >= 0) dp[i] = Math.max(dp[i], dp[i - b]);

            if (i - c >= 0) dp[i] = Math.max(dp[i], dp[i - c]);

            if (dp[i] != -1)
                dp[i]++;
        }

        return dp[n];

    }
}
