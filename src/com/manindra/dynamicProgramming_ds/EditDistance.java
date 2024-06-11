package com.manindra.dynamicProgramming_ds;

public class EditDistance {

    public static void main(String[] args) {

        // String s1 = "CAT", s2 = "CUT";
        String s1 = "SATURDAY", s2 = "SUNDAY";
        //System.out.println(eDRecursive(s1, s2, s1.length(), s2.length()));
        System.out.println(eDDynamicProgramming(s1, s2, s1.length(), s2.length()));
    }

    static int eDRecursive(String str1, String str2, int len1, int len2) {
        // If first string is empty, the only option is to insert all characters of the second string
        if (len1 == 0)
            return len2;

        // If second string is empty, the only option is to remove all characters of the first string
        if (len2 == 0)
            return len1;

        // If the last characters are the same, ignore the last character and recurse for the remaining strings
        if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1))
            return eDRecursive(str1, str2, len1 - 1, len2 - 1);

        // If the last characters are different, consider all possibilities and find the minimum
        return 1 + Math.min(
                eDRecursive(str1, str2, len1, len2 - 1), // Insert
                Math.min(
                        eDRecursive(str1, str2, len1 - 1, len2), // Remove
                        eDRecursive(str1, str2, len1 - 1, len2 - 1) // Replace
                )
        );
    }

    static int eDDynamicProgramming(String str1, String str2, int len1, int len2) {
        int[][] dp = new int[len1 + 1][len2 + 1];

        // Initialize the first row and first column
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i; // If str2 is empty, we need i insertions
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j; // If str1 is empty, we need j insertions
        }

        // Fill the dp array
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[len1][len2];
    }
}
