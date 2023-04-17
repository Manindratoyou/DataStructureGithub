package com.manindra.stack;

import java.util.Stack;

public class StringReverse {

    public static void main(String[] args) {

        String str="ABCD";
        System.out.println("Before reverse ->" +str);
        System.out.println("after reverse ->" +reverse(str));
    }

    public static String reverse(String str){
        Stack<Character> stack=new Stack<>();
        char[] ch=str.toCharArray();

        for (char c:ch) {
            stack.push(c);
        }
        for(int i=0;i<str.length();i++){
            ch[i]=stack.pop();
        }
        return new String(ch);
    }
}
