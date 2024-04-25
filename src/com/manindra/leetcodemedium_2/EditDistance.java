package com.manindra.leetcodemedium_2;

public class EditDistance { //leet code solution 72

    public static void main(String[] args) {
        // Test cases
        String word1_1 = "horse";
        String word2_1 = "ros";
        System.out.println("Test Case 1: " + minDistance(word1_1, word2_1));

        String word1_2 = "intention";
        String word2_2 = "execution";
        System.out.println("Test Case 2: " + minDistance(word1_2, word2_2));

        // Add more test cases as needed
    }

    static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] := min operation to convert word1 to word2
        int[][] costDp = new int[m + 1][n + 1];

        // initialize dp matrix
        for (int i = 1; i <= m; i++)
            costDp[i][0] = i;
        for (int j = 1; j <= n; j++)
            costDp[0][j] = j;

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {

                // same characters
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    // copy from top left
                    costDp[i][j] = costDp[i - 1][j - 1];
                else {
                    // get minimum of all three neighbors
                    int topLeft = costDp[i - 1][j - 1];
                    int top = costDp[i - 1][j];
                    int left = costDp[i][j - 1];
                    costDp[i][j] = Math.min(topLeft, Math.min(top, left)) + 1;
                }
            }
        }
        return costDp[m][n];
    }
}
