package com.manindra.dynamicprogramming_leetcode;

public class IntegerBreak { //solution 343

    public static void main(String[] args) {
        IntegerBreak obj = new IntegerBreak();
        System.out.println(obj.integerBreak(10)); // Output: 36
    }

    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

    public int integerBreak2(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }

        return result * n; // remaining n is 2, 3 or 4
    }
}

