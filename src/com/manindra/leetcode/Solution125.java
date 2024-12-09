package com.manindra.leetcode;

public class Solution125 { //Valid Palindrome

    public static void main(String[] args) {

        String input1 = "A man , a plan , a canal : Panama";
        String input2 = "race a car";
        System.out.println(isPalindrome(input1));
        System.out.println(isPalindrome(input2));
    }

    static boolean isPalindrome(String input) {

        if (input == null || input.length() == 0) return true;

        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); //amanaplanacanalpanama
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) return false;
            left++;
            right--;

        }
        return true;
    }
}
