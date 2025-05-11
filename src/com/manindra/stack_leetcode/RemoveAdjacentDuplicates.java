package com.manindra.stack_leetcode;

import java.util.Stack;

public class RemoveAdjacentDuplicates { //solution 1047

    public static void main(String[] args) {
        String s = "abbaca";
        String s1 = "azxxzy";
        System.out.println(removeDuplicates(s));  // Output: "ca"
        System.out.println(removeDuplicates2(s1));  // Output: "ay"
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop(); // Remove adjacent duplicate
            } else {
                stack.push(ch); // Add character
            }
        }

        // Reconstruct result string from stack
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }

    public static String removeDuplicates2(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == ch) {
                sb.deleteCharAt(len - 1); // remove top of the sb
            } else {
                sb.append(ch); // push onto sb
            }
        }

        return sb.toString();
    }
}

