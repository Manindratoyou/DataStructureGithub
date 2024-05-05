package com.manindra.leetcodemedium_2;

public class LongestCommonSubsequence { //solution 1143

    public static void main(String[] args) {

        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));

    }

    static int longestCommonSubsequence(String tex1, String text2) {
        //construct dp matrix
        int[][] dp = new int[tex1.length() + 1][text2.length() + 1];

        //iterate over each cell and update value
        for (int i = 1; i <= tex1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (tex1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        //return the value in the last cell
        return dp[tex1.length()][text2.length()];
    }
}
