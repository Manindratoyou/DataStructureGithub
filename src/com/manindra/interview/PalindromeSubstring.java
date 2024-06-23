package com.manindra.interview;

import java.util.ArrayList;
import java.util.List;

public class PalindromeSubstring {

    public static void main(String[] args) {
        String input = "TENET";
        List<String> result = allPalindromeSubstrings(input);

        System.out.println(result);
    }

    public static List<String> allPalindromeSubstrings(String str) {
        List<String> palindromes = new ArrayList<>(); // set concept uniqueness

        for (int i = 0; i < str.length(); i++) {
            extendPalindrome(str, i, i, palindromes);      // Odd length palindrome
            extendPalindrome(str, i, i + 1, palindromes);  // Even length palindrome
        }

        return palindromes;
    }

    private static void extendPalindrome(String str, int left, int right, List<String> palindromes) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            palindromes.add(str.substring(left, right + 1));
            left--;
            right++;
        }
    }

}
