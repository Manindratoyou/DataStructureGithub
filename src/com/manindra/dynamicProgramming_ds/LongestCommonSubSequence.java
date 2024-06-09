package com.manindra.dynamicProgramming_ds;

import java.util.Arrays;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        String s1 = "CDA", s2 = "DBA";
        System.out.println(longestCommonSubSequence(s1, s2, s1.length(), s2.length()));

        int[][] memoizationTable = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : memoizationTable) {
            Arrays.fill(row, -1);
        }
        System.out.println(longestCommonSubSequenceMemoized(s1, s2, s1.length(), s2.length(), memoizationTable));
    }

    // Time Complexity: O(2^(m+n)), Auxiliary Space: O(m+n)
    static int longestCommonSubSequence(String s1, String s2, int length1, int length2) {
        if (length1 == 0 || length2 == 0)
            return 0;
        if (s1.charAt(length1 - 1) == s2.charAt(length2 - 1))
            return 1 + longestCommonSubSequence(s1, s2, length1 - 1, length2 - 1);
        else
            return Math.max(longestCommonSubSequence(s1, s2, length1 - 1, length2),
                    longestCommonSubSequence(s1, s2, length1, length2 - 1));
    }

    static int longestCommonSubSequenceMemoized(String s1, String s2, int length1, int length2, int[][] memo) {

        if (memo[length1][length2] != -1)
            return memo[length1][length2];
        if (length1 == 0 || length2 == 0)
            memo[length1][length2] = 0;
        else {
            if (s1.charAt(length1 - 1) == s2.charAt(length2 - 1))
                memo[length1][length2] = 1 + longestCommonSubSequenceMemoized(s1, s2, length1 - 1, length2 - 1, memo);
            else {
                memo[length1][length2] = Math.max(longestCommonSubSequenceMemoized(s1, s2, length1 - 1, length2, memo),
                        longestCommonSubSequenceMemoized(s1, s2, length1, length2 - 1, memo));
            }
        }
        return memo[length1][length2];
    }
}
