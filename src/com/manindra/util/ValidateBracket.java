package com.manindra.util;

import java.util.Stack;

public class ValidateBracket {

    public static void main(String[] args) {
        String bracket = "{()[{()()}]}";
        System.out.println(validateBracket(bracket));
    }

    static boolean validateBracket(String bracket) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < bracket.length(); i++) {
            char currentCharactor = bracket.charAt(i);
            if (currentCharactor == '(' || currentCharactor == '{' || currentCharactor == '[') {
                stack.push(currentCharactor);
            }
            if ((currentCharactor == ')' && stack.peek() == '(') ||
                    (currentCharactor == '}' && stack.peek() == '{') ||
                    (currentCharactor == ']' && stack.peek() == '[')) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
