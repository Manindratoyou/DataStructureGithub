package com.manindra.dynamicprogramming_leetcode;

public class TribonacciNumber { //solution 1137

    public static void main(String[] args) {
        int n = 4;
        System.out.println(tribonacci1(n));  // Output: 4
    }

    public static int tribonacci1(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 0, b = 1, c = 1, result = 0;

        for (int i = 3; i <= n; i++) {
            result = a + b + c;
            a = b;
            b = c;
            c = result;
        }

        return result;
    }
    public static int tribonacci2(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return tribonacci2(n - 1) + tribonacci2(n - 2) + tribonacci2(n - 3);
    }

    public static int tribonacci3(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }



}

