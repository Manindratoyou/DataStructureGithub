package com.manindra.util;

import java.util.Stack;
import java.util.stream.Collectors;

public class SuperReducedString {

    public static void main(String[] args) {
        System.out.println(superReducedString("aaabccddd")); // Expected: "abd"
        System.out.println(superReducedString("baab")); // Expected: "Empty String"
        System.out.println(superReducedString("abc")); // Expected: "abc"
        System.out.println(superReducedString("aabbcc")); // Expected: "Empty String"
        System.out.println(superReducedString("abba")); // Expected: "Empty String"
    }

    public static String superReducedString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch)
                stack.pop();
            else
                stack.push(ch);
        }
        if (stack.isEmpty())
            return "Empty String";
        else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }

    public static String superReducedStringUsingJava8(String str) {
        Stack<Character> stack = new Stack<>();
        str.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> {
                    if (!stack.isEmpty() && stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                });

        String result = stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return result.isEmpty() ? "Empty String" : result;
    }

    public String superReducedString2(String str) {

        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) == str.charAt(i - 1)) {
                str = str.substring(0, i - 1) + str.substring(i + 1);
                i = 0;
            }
        }

        return str.length() == 0 ? "Empty String" : str;
    }

    public String superReducedStringUsingStacks(String str) {

        Stack<Character> characterStack = new Stack<>();

        for (char c : str.toCharArray()) {

            if (characterStack.isEmpty())
                characterStack.push(c);
            else if (c == characterStack.peek())
                characterStack.pop();
            else
                characterStack.push(c);
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (Character character : characterStack)
            resultBuilder.append(character);

        return resultBuilder.length() == 0 ?
                "Empty String" : resultBuilder.toString();
    }
}
