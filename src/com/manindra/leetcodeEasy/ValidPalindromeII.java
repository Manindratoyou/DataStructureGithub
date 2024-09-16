package com.manindra.leetcodeEasy;

public class ValidPalindromeII { //solution 680

    public static void main(String[] args) {

        String s = "abca";
        String s1 = "rotatxor";
        System.out.println(validPalindrome(s));
    }

    static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            //keep moving till the characters match
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                //try deleting 1 character from either direction
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else
                return false;
        }
        return true;
    }
}
