package com.manindra.stack_leetcode;

import java.util.Stack;

public class MakeStringGreat { //solution 1544

    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));   // Output: "leetcode"
        System.out.println(makeGood("abBAcC"));        // Output: ""
        System.out.println(makeGood("s"));             // Output: "s"
        System.out.println(makeGood("mMabcCcBA"));     // Output: "a"
        System.out.println(makeGood2("mMabcCcBA"));     // Output: "a"
    }

    public static String makeGood(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = stack.length();
            if (len > 0 && Math.abs(stack.charAt(len - 1) - c) == 32) {
                stack.deleteCharAt(len - 1);  // remove the bad pair
            } else {
                stack.append(c);  // push to stack
            }
        }

        return stack.toString();
    }

    public static String makeGood2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
                stack.pop(); // Remove bad pair
            } else {
                stack.push(c); // Keep character
            }
        }

        // Build the final string from stack
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}

