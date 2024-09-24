package com.manindra.leetcodemedium_2;

public class LongestPalindromicSubstring { //solution 5

    public static void main(String[] args) {
        String str1 = "babad";
        String str2 = "cbbd";
        String str3 = "a";
        String str4 = "ac";

        System.out.println(longestPalindrome(str1)); // Expected: "bab" or "aba"
        System.out.println(longestPalindrome(str2)); // Expected: "bb"
        System.out.println(longestPalindrome(str3)); // Expected: "a"
        System.out.println(longestPalindrome(str4)); // Expected: "a" or "c"
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
}

