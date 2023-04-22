package com.manindra.util;

import java.util.Stack;

public class SuperReducedString {

    public static void main(String[] args) {
        System.out.println(superReducedString("aaabccddd"));
    }

    public static String superReducedString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray())
        {
            if(!stack.isEmpty() && stack.peek()==ch)
                stack.pop();
            else
                stack.push(ch);
        }
        if(stack.isEmpty())
            return "Empty String";
        else
        {
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty())
            {
                sb.append(stack.peek());
                stack.pop();
            }
            sb.reverse();
            String result = String.valueOf(sb);
            return result;
        }
    }

}
