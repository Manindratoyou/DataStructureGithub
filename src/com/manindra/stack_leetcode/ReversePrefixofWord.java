package com.manindra.stack_leetcode;

import java.util.Stack;

public class ReversePrefixofWord { //solution 2000

    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        String word1 = " xyxzxe";
        char ch1 = 'x';
        String word2 = "abcd";
        char ch2 = 'z';
        System.out.println(reversePrefix(word, ch)); // Expected output: "dcbaefd"
        System.out.println(reversePrefixSolutionTwo(word, ch)); // Expected output: "dcbaefd"
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

    static String reversePrefixSolutionTwo(String word, char ch) {
        // Find the index of the first occurrence of ch
        int index = word.indexOf(ch);

        // If the character is not found, return the original word
        if (index == -1) {
            return word;
        }

        // Reverse the prefix using StringBuilder
        StringBuilder prefix = new StringBuilder(word.substring(0, index + 1));
        prefix.reverse();

        // Append the rest of the word
        return prefix.append(word.substring(index + 1)).toString();
    }

    public String reversePrefix3(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int n = word.indexOf(ch);

        for (int i = n; i >= 0; i--) {
            sb.append(word.charAt(i));
        }

        for (int i = n + 1; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }

        return sb.toString();
    }
}
