package com.manindra.hackerrank;

/**
 * Problem: Common Child
 *
 * A string is a child of another string if it is formed by deleting 0 or more
 * characters from the other string without rearranging the remaining characters.
 * Given two strings, find the length of the longest string that can be formed
 * by deleting characters from both strings such that the resulting strings are identical.
 *
 * Input Format:
 * - Two strings, `s1` and `s2`.
 *
 * Output Format:
 * - Print a single integer denoting the length of the longest common child string.
 *
 * Constraints:
 * - 1 <= |s1|, |s2| <= 5000
 * - All characters are uppercase English letters.
 *
 * Examples:
 * 1. Input: "HARRY", "SALLY"
 *    Output: 2
 *
 *    Explanation: The longest common child string is "AY".
 *
 * 2. Input: "ABCDEF", "FBDAMN"
 *    Output: 2
 *
 *    Explanation: The longest common child string is "BD".
 *
 * Approach:
 * - Use Dynamic Programming to find the Longest Common Subsequence (LCS).
 * - Create a DP table to store results for overlapping subproblems.
 */

public class CommonChild { // similar leet code 1143. Longest Common Subsequence

    public static void main(String[] args) {
        // Test cases
        System.out.println(commonChild("HARRY", "SALLY"));       // Output: 2
        System.out.println(commonChild("SHINCHAN", "NOHARAAA")); // Output: 3
        System.out.println(commonChild("ABCDEF", "FBDAMN"));     // Output: 2
    }

    public static int commonChild(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a DP table
        int[][] dp = new int[m + 1][n + 1];

        // Fill the table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the longest common child string
        return dp[m][n];
    }
}

