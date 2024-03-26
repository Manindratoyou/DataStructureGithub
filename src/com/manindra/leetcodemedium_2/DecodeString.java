package com.manindra.leetcodemedium_2;

import java.util.Stack;

public class DecodeString { //solution 394

    /*
    Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
     */

    public static void main(String[] args) {
        String s="3[a]2[bc]";
        DecodeString decodeString=new DecodeString();
        System.out.println(decodeString.decodeString(s));
    }

    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int k = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                k = (k * 10) + (c - '0');
                continue;
            }

            if (c == '[') {
                numStack.push(k);
                k = 0;
                stringStack.push(String.valueOf(c));
                continue;
            }

            if (c != ']') {
                stringStack.push(String.valueOf(c));
                continue;
            }

            StringBuilder temp = new StringBuilder();
            while (!stringStack.peek().equals("["))
                temp.insert(0, stringStack.pop());

            // remove the "["
            stringStack.pop();

            // Get the new string
            StringBuilder replacement = new StringBuilder();
            int count = numStack.pop();
            for (int i = 0; i < count; i++)
                replacement.append(temp);

            // Add it to the stack
            stringStack.push(replacement.toString());
        }

        StringBuilder result = new StringBuilder();
        while (!stringStack.empty()) {
            result.insert(0, stringStack.pop());
        }
        return result.toString();
    }
}
