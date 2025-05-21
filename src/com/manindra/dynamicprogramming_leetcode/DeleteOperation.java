package com.manindra.dynamicprogramming_leetcode;

public class DeleteOperation { //solution 583

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill dp table for LCS
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int lcs = dp[m][n];
        return (m - lcs) + (n - lcs); // Total deletions needed
    }

    public static void main(String[] args) {
        DeleteOperation obj = new DeleteOperation();

        // Test Case 1
        String word1 = "sea", word2 = "eat";
        System.out.println("Min deletions to make \"" + word1 + "\" and \"" + word2 + "\" equal: "
                + obj.minDistance(word1, word2)); // Expected: 2

        // Test Case 2
        word1 = "leetcode"; word2 = "etco";
        System.out.println("Min deletions to make \"" + word1 + "\" and \"" + word2 + "\" equal: "
                + obj.minDistance(word1, word2)); // Expected: 4

        // Test Case 3
        word1 = "abc"; word2 = "abc";
        System.out.println("Min deletions to make \"" + word1 + "\" and \"" + word2 + "\" equal: "
                + obj.minDistance(word1, word2)); // Expected: 0

        // Test Case 4
        word1 = "abc"; word2 = "def";
        System.out.println("Min deletions to make \"" + word1 + "\" and \"" + word2 + "\" equal: "
                + obj.minDistance(word1, word2)); // Expected: 6

        // Test Case 5
        word1 = ""; word2 = "abc";
        System.out.println("Min deletions to make \"" + word1 + "\" and \"" + word2 + "\" equal: "
                + obj.minDistance(word1, word2)); // Expected: 3
    }
}

