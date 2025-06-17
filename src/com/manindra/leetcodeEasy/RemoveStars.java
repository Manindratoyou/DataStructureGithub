package com.manindra.leetcodeEasy;

import java.util.Stack;

public class RemoveStars { //solution 2390

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));     // Output: "lecoe"
        System.out.println(removeStars("erase*****"));      // Output: ""
        System.out.println(removeStars("a*b*c*"));           // Output: ""
        System.out.println(removeStars("abc*d**e*f*"));      // Output: "a"
    }

    public static String removeStars(String s) {
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);  // simulate pop
                }
            } else {
                result.append(ch);  // simulate push
            }
        }

        return result.toString();
    }

    public static String removeStars2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();  // remove the previous character
                }
            } else {
                stack.push(ch);  // keep the character
            }
        }

        // Convert stack to string
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}

