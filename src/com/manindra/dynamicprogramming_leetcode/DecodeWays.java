package com.manindra.dynamicprogramming_leetcode;

/*
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 */
public class DecodeWays { //solution 91

    public static void main(String[] args) {

        String s = "12";
        String s1 = "122016";
        System.out.println(numDecoding(s));
        System.out.println(numDecoding(s1));

    }

    static int numDecoding(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1)
                dp[i] += dp[i - 1];
            if (twoDigit >= 10 && twoDigit <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}
