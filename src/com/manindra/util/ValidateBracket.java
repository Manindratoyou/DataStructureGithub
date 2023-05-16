package com.manindra.util;

import java.util.Stack;

public class ValidateBracket {

    public static void main(String[] args) {
        String bracket= "{()[{()()}]}";
        System.out.println(validateBracket(bracket));
    }

    static boolean validateBracket(String bracket){

        Stack<Character> characterStack=new Stack<>();
        for (int i=0;i<bracket.length();i++){
            char currentCharactor=bracket.charAt(i);
            if (currentCharactor=='(' || currentCharactor=='{' || currentCharactor=='['){
                characterStack.push(currentCharactor);
            }
            if ((currentCharactor==')' && characterStack.peek()=='(') ||
                    (currentCharactor=='}' && characterStack.peek()=='{') ||
                    (currentCharactor==']' && characterStack.peek()=='[')){
                characterStack.pop();
            }
        }
        return characterStack.isEmpty();
    }
}
