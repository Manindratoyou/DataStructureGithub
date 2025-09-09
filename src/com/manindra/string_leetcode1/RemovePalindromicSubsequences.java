package com.manindra.string_leetcode1;

public class RemovePalindromicSubsequences { //solution 1332

    public static void main(String[] args) {
        System.out.println(removePalindromeSub("ababa")); // 1
        System.out.println(removePalindromeSub("abb"));   // 2
        System.out.println(removePalindromeSub("baabb")); // 2
        System.out.println(removePalindromeSub(""));      // 0
    }

    public static int removePalindromeSub(String s) {
        if (s.isEmpty()) return 0;
        return isPalindrome(s) ? 1 : 2;
    }

    // Helper method to check palindrome
    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
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

