package com.manindra.leetcode;

import java.util.Collections;

public class Solution557 { //Reverse Words in a String III

    public static void main(String[] args) {
        String input = "Let's code in Java";
        String reversed = reverseWords(input);

        System.out.println("Reversed Words: " + reversed);
    }



    //Time Complexity: O(m * n)
    //Auxiliary Space: O(m), where m is the average length of words in the input string
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(reverseString(word)).append(" ");
        }

        return result.toString().trim();
    }

    private static String reverseString(String s) {
        char[] charArray = s.toCharArray();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray);
    }

    //Time Complexity: O(n)  Auxiliary Space: O(1)
    public static String reverseWordsSolutionTwo(String s) {
        char[] charArray = s.toCharArray();
        int start = 0;

        for (int end = 0; end < charArray.length; end++) {
            if (charArray[end] == ' ') {
                reverse(charArray, start, end - 1);
                start = end + 1;
            }
        }

        reverse(charArray, start, charArray.length - 1);

        return new String(charArray);
    }

    private static void reverse(char[] charArray, int start, int end) {
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;

            start++;
            end--;
        }
    }


}
