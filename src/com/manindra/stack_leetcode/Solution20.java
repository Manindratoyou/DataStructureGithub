package com.manindra.stack_leetcode;

import java.util.Stack;

//valid parenthesis different solution
public class Solution20 {

    public static void main(String[] args) {
        String bracket= "{()[{()()}]}";
        System.out.println(validateBracket(bracket));//true
        System.out.println(validateBracket("]")); // Output: false
    }

    static boolean validateBracket(String bracket) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < bracket.length(); i++) {
            char currentCharacter = bracket.charAt(i);
            if (currentCharacter == '(' || currentCharacter == '{' || currentCharacter == '[') {
                characterStack.push(currentCharacter);
            } else {
                // Check if the stack is not empty before peeking
                if (!characterStack.isEmpty() &&
                        ((currentCharacter == ')' && characterStack.peek() == '(') ||
                                (currentCharacter == '}' && characterStack.peek() == '{') ||
                                (currentCharacter == ']' && characterStack.peek() == '['))) {
                    characterStack.pop();
                } else {
                    // If the stack is empty or the characters don't match, it's not balanced
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }

    public boolean isValid(String s){
        Stack<Character> stack=new Stack<>();

        for (char c: s.toCharArray()){
            if (c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else {
                if (stack.isEmpty())
                    return false;
                char top=stack.pop();
                if (c==')' && top!='(')
                    return false;//mismatched closing parenthesis
                if (c==']' && top!='[')
                    return false;//mismatched closing parenthesis
                if (c=='}' && top!='{')
                    return false;//mismatched closing parenthesis
            }
        }
        return stack.isEmpty(); //check if all opening character have been matched
    }

    public boolean isValidSolTwo(String s){

        int countParenthesis=0;
        int countBrackets=0;
        int countBraces=0;

        for (char c :s.toCharArray()){
            switch (c){
                case '(' :
                    countParenthesis++;
                    break;
                case ')' :
                    countParenthesis--;
                    if (countParenthesis<0)
                        return false;//more closing parenthesis than opening
                    break;
                case '[' :
                    countBrackets++;
                    break;
                case ']' :
                    countBrackets--;
                    if (countBrackets<0)
                        return false;//more closing brackets than opening
                    break;

                case '{' :
                    countBraces++;
                    break;
                case '}' :
                    countBraces--;
                    if (countBraces<0)
                        return false;//more closing braces than opening
                    break;

                default:
                    return false;//Invalid character
            }
        }
        return countParenthesis==0 &&countBrackets==0 && countBraces==0;
    }

    public boolean isValidSolThree(String s){
        String openChars="([{";
        String closeChars=")]}";
        StringBuilder builder=new StringBuilder();

        for (char c: s.toCharArray()){
            if (openChars.indexOf(c)!=-1){
                //found an opening character , so append its corresponding closing character
                builder.append(closeChars.charAt(openChars.indexOf(c)));
            } else if (closeChars.indexOf(c) !=-1) {
                //found a closing character
                if (builder.length()==0 ||builder.charAt(builder.length()-1) !=c)
                    return false; //mismatched closing character
                builder.deleteCharAt(builder.length()-1);
            }else
                return false;
        }
        return builder.length()==0;
    }

    static boolean isValidSolutionFour(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');

            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();

    }
}
