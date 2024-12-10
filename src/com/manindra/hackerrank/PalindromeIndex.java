package com.manindra.hackerrank;

/**
 * Problem Description:
 *
 * You are given a string `s` that may or may not be a palindrome. Your task is to find the index
 * of the character that can be removed to make the string a palindrome. If the string is already
 * a palindrome, return `-1`. If it's not possible to make the string a palindrome by removing a
 * single character, return `-1`.
 *
 * A palindrome is a string that reads the same backward as forward.
 *
 * Input Format:
 * - A single string `s`.
 *
 * Output Format:
 * - Return the zero-based index of the character to remove to make the string a palindrome,
 *   or `-1` if the string is already a palindrome or cannot be fixed by one removal.
 *
 * Constraints:
 * - 1 ≤ |s| ≤ 10^5
 * - `s` consists of lowercase English letters only.
 *
 * Examples:
 * 1. Input: "aaab"
 *    Output: 3 (Removing the character 'b' makes the string "aaa", which is a palindrome)
 *
 * 2. Input: "baa"
 *    Output: 0 (Removing the character 'b' makes the string "aa", which is a palindrome)
 *
 * 3. Input: "aaa"
 *    Output: -1 (The string is already a palindrome)
 *
 * 4. Input: "abc"
 *    Output: -1 (The string cannot be made a palindrome by removing one character)
 */
public class PalindromeIndex {

    public static void main(String[] args) {
        System.out.println(palindromeIndex("aaab")); // Output: 3
        System.out.println(palindromeIndex("baa"));  // Output: 0
        System.out.println(palindromeIndex("aaa"));  // Output: -1
    }

    public static int palindromeIndex(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // If characters match, move pointers
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // Check if removing either `left` or `right` index makes it a palindrome
                if (isPalindrome(s, left + 1, right)) {
                    return left; // Removing the left character fixes the issue
                } else if (isPalindrome(s, left, right - 1)) {
                    return right; // Removing the right character fixes the issue
                } else {
                    return -1; // Not possible to fix with one removal
                }
            }
        }

        return -1; // Already a palindrome
    }

    static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
