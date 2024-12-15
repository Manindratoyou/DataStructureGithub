package com.manindra.leetcodemedium_2;

public class LongestCommonSubsequence { //solution 1143 /similar common child hacker rank

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

    static int longestCommonSubString(String m,String n){
        char[] str1=m.toCharArray();
        char[] str2=n.toCharArray();

        int [] [] dp=new int[str1.length+1][str2.length+1];

        int max=0;
        //iterate over each position in the matrix
        for (int i=1;i<=str1.length;i++) {
            for (int j = 1; j < str2.length; j++) {
                //if characters are equals
                if (str1[i - 1] == str2[j - 1]) {
                    //get the number from diagonally opposite and add 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
}
