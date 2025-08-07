package com.manindra.bit_manipulation_leetcode;

import java.util.Arrays;

public class CountingBits { //solution 338

    public static void main(String[] args) {
        int n = 5;
        int[] result = countBits(n);
        System.out.println(Arrays.toString(result)); // [0, 1, 1, 2, 1, 2]
    }

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = countOnes(i);
        }
        return result;
    }

    private static int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }

    public static int[] countBitsDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
