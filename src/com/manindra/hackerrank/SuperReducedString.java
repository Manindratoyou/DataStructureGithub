package com.manindra.hackerrank;

import java.util.Stack;

public class SuperReducedString {

    public static void main(String[] args) {

        String str1 = "aaabccddd";
        String str2 = "abbcccb";
        String str3 = "xyz";
        String str4 = "aaaa";
        String str5 = "";

        // Test method superReducedString
        System.out.println("Reduced string for str1: " + superReducedString(str1));
        System.out.println("Reduced string for str2: " + superReducedString(str2));
        System.out.println("Reduced string for str3: " + superReducedString(str3));
        System.out.println("Reduced string for str4: " + superReducedString(str4));
        System.out.println("Reduced string for str5: " + superReducedString(str5));

        // Test method superReducedStringUsingStack
        System.out.println("Reduced string using stack for str1: " + superReducedStringUsingStack(str1));
        System.out.println("Reduced string using stack for str2: " + superReducedStringUsingStack(str2));
        System.out.println("Reduced string using stack for str3: " + superReducedStringUsingStack(str3));
        System.out.println("Reduced string using stack for str4: " + superReducedStringUsingStack(str4));
        System.out.println("Reduced string using stack for str5: " + superReducedStringUsingStack(str5));
    }

    static String superReducedString(String str) {

        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) == str.charAt(i - 1)) {
                str = str.substring(0, i - 1) + str.substring(i + 1);
                i = 0;
            }
        }
        return str.length() == 0 ? "Empty String" : str;
    }

    static String superReducedStringUsingStack(String str) {

        Stack<Character> characterStack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (characterStack.isEmpty())
                characterStack.push(c);
            else if (c == characterStack.peek()) {
                characterStack.pop();
            } else
                characterStack.push(c);
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (Character character : characterStack) {
            resultBuilder.append(character);
        }

        return resultBuilder.length() == 0 ? "Empty String" : resultBuilder.toString();

    }
}
