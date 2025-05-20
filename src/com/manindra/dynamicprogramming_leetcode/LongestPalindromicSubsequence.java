package com.manindra.dynamicprogramming_leetcode;

public class LongestPalindromicSubsequence { //solution 516

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubsequence("bbbab")); // Output: 4 ("bbbb")
        System.out.println(longestPalindromicSubsequence("cbbd"));  // Output: 2 ("bb")
    }

    static int longestPalindromicSubsequence(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == reversed.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

}
