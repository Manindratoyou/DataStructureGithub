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
            char currentCharacter = bracket.charAt(i);
            if (currentCharacter == '(' || currentCharacter == '{' || currentCharacter == '[') {
                stack.push(currentCharacter);
            }
            if ((currentCharacter == ')' && stack.peek() == '(') ||
                    (currentCharacter == '}' && stack.peek() == '{') ||
                    (currentCharacter == ']' && stack.peek() == '[')) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    static boolean isValid(String s){
        Stack<Character> stack=new Stack<>();

        for (char c: s.toCharArray()){
            if (c=='(' ||c=='{' ||c=='['){
                stack.push(c);
            } else if (c==')' ||c=='}' ||c==']') {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(),c))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    static boolean isMatchingPair(char open, char close){
        return (open=='(' && close==')'
                || open=='{' && close=='}'
                || open=='[' && close==']');
    }
}
