package com.manindra.stack_leetcode;

import java.util.Stack;

public class RemoveOutermostParentheses { //solution 1021

    public static void main(String[] args) {
        RemoveOutermostParentheses obj = new RemoveOutermostParentheses();

        String s1 = "(()())(())";
        System.out.println(obj.removeOuterParentheses(s1)); // Output: "()()()"
        System.out.println(obj.removeOuterParentheses2(s1)); // Output: "()()()"

        String s2 = "(()())(())(()(()))";
        System.out.println(obj.removeOuterParentheses(s2)); // Output: "()()()()(())"

        String s3 = "()()";
        System.out.println(obj.removeOuterParentheses(s3)); // Output: ""
    }

    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (!stack.isEmpty()) {
                    result.append(ch); // not outermost
                }
                stack.push(ch);
            } else if (ch == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.append(ch); // not outermost
                }
            }
        }

        return result.toString();
    }

    public String removeOuterParentheses2(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (depth > 0) result.append(ch); // not outermost
                depth++;
            } else { // ch == ')'
                depth--;
                if (depth > 0) result.append(ch); // not outermost
            }
        }

        return result.toString();
    }
}

