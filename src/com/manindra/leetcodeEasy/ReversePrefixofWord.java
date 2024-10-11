package com.manindra.leetcodeEasy;

import java.util.Stack;

public class ReversePrefixofWord { //solution 2000

    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch)); // Expected output: "dcbaefd"
    }

    static String reversePrefix(String word, char ch) {
        int firstOccurrence = word.indexOf(ch);
        if (firstOccurrence == -1)
            return word;
        Stack<Character> stack = new Stack<>();

        // Add all elements up to and including the first occurrence of ch to the stack
        for (int i = 0; i <= firstOccurrence; i++) {
            stack.push(word.charAt(i));
        }

        StringBuilder result = new StringBuilder();

        // Pop elements from the stack and append to result
        while (!stack.isEmpty())
            result.append(stack.pop());

        // Append the remaining characters of the word to result
        for (int i = firstOccurrence + 1; i < word.length(); i++) {
            result.append(word.charAt(i));
        }

        return result.toString();
    }
}
