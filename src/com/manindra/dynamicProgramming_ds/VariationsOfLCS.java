package com.manindra.dynamicProgramming_ds;

import java.util.*;

public class VariationsOfLCS {


    public static void main(String[] args) {
        System.out.println("1. LCS length: " + lcsLength("abcde", "ace"));
        System.out.println("2. Insert/Delete: " + Arrays.toString(minInsertDelete("heap", "pea")));
        System.out.println("3. SCS length: " + shortestCommonSupersequence("AGGTAB", "GXTXAYB"));
        System.out.println("4. Longest Palindromic Subsequence: " + longestPalindromicSubsequence("bbbab"));
        System.out.println("5. Longest Repeating Subsequence: " + longestRepeatingSubsequence("aabebcdd"));
        System.out.println("6. Space Optimized LCS: " + spaceOptimizedLCS("abcde", "ace"));
        System.out.println("7. Print LCS: " + printLCS("abcde", "ace"));
    }

    // 1. Diff Utility (LCS Length)
    public static int lcsLength(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    // 2. Min Insertions and Deletions to Convert s1 into s2
    public static int[] minInsertDelete(String s1, String s2) {
        int lcs = lcsLength(s1, s2);
        return new int[]{s1.length() - lcs, s2.length() - lcs}; // [deletions, insertions]
    }

    // 3. Shortest Common Supersequence
    public static int shortestCommonSupersequence(String s1, String s2) {
        int lcs = lcsLength(s1, s2);
        return s1.length() + s2.length() - lcs;
    }

    // 4. Longest Palindromic Subsequence
    public static int longestPalindromicSubsequence(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return lcsLength(s, rev);
    }

    // 5. Longest Repeating Subsequence
    public static int longestRepeatingSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][n];
    }

    // 6. Space Optimized LCS
    public static int spaceOptimizedLCS(String s1, String s2) {
        int[] prev = new int[s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            int[] curr = new int[s2.length() + 1];
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[s2.length()];
    }

    // 7. Printing LCS
    public static String printLCS(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString();
    }

}

