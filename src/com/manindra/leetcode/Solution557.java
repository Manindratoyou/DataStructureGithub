package com.manindra.leetcode;

import java.util.Stack;

public class Solution557 { //Reverse Words in a String III

    public static void main(String[] args) {
        String input = "Let's code in Java";
        String reversed = reverseWords(input);
        String reversed1 = reverseWord3(input);
        String reversed2 = reverseWord4(input);

        System.out.println("Reversed Words: " + reversed);
        System.out.println("Reversed Words: " + reversed1);
        System.out.println("Reversed Words: " + reversed2);
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

    static String reverseWord3(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = 0;
        while (right < arr.length) {
            //if we find a space ,reverse the word
            if (arr[right] == ' ') {
                reverse(arr, left, right - 1);
                left = right + 1;
            }
            right++;
        }
        //reverse the last word
        reverse(arr, left, right - 1);

        return new String(arr);
    }

    static String reverseWord4(String s) {

        StringBuilder result = new StringBuilder();//stringbuilder to store the final result
        Stack<Character> stack = new Stack<>();//stack to store characters of each word

        //iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                //if a space is encountered,pop all characters from the stack and append to the result.
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append(c);//append the space character to the result
            } else {
                //if the character is not a space ,push it into the stack
                stack.push(c);
            }
        }
        //after the loop ,pop any remaining characters in the stack (for the last word)
        while (!stack.isEmpty())
            result.append(stack.pop());

        //return the final reversed string
        return result.toString();
    }

}
