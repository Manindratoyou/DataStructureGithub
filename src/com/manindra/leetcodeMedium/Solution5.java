package com.manindra.leetcodeMedium;

public class Solution5 { //Longest Palindromic Substring

    public static void main(String[] args) {

        // Test Case 1: General case with a single palindrome
        String result1 = longestPalindrome("babad");
        System.out.println(result1);  // Output: "bab" or "aba"

        // Test Case 2: Edge case with an empty string
        String result2 = longestPalindrome("");
        System.out.println(result2);  // Output: ""

        // Test Case 3: Single character string
        String result3 = longestPalindrome("a");
        System.out.println(result3);  // Output: "a"

        // Test Case 4: All characters are the same
        String result4 = longestPalindrome("ccc");
        System.out.println(result4);  // Output: "ccc"

        // Test Case 5: No palindrome, different characters
        String result5 = longestPalindrome("xyz");
        System.out.println(result5);  // Output: "x", "y", or "z"

        // Test Case 6: Even length palindrome
        String result6 = longestPalindrome("abba");
        System.out.println(result6);  // Output: "abba"

        // Test Case 7: Even length palindrome with different characters
        String result7 = longestPalindrome("xyzyx");
        System.out.println(result7);  // Output: "xyzyx"

        // Test Case 8: Even length palindrome with different characters
        String result8 = longestPalindromeSolutionTwo("ebbabad");
        System.out.println(result8);  // Output: "aba" or "bab"
    }


    static String longestPalindrome(String str) {

        if (str.length() <= 1)
            return str;

        String LPS = "";

        for (int i = 1; i < str.length(); i++) {

            // Consider odd length
            int low = i;
            int high = i;
            while(str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == str.length())
                    break;
            }

            String palindrome = str.substring(low+1, high);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }

            // Consider even length
            low = i-1;
            high = i;
            while(str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == str.length())
                    break;
            }

            palindrome = str.substring(low+1, high);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }
        }

        return LPS;
    }

    static String longestPalindromeSolutionTwo(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
