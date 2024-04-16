package com.manindra.stack_ds;

import java.util.Stack;

public class BalancedParenthesis {

    public static void main(String[] args) {

        String str="{}([()])";
        System.out.println(isBalanced(str));

    }

    static boolean isBalanced(String str){

        Stack<Character> stack=new Stack<>();

        for (int i=0;i<str.length();i++){
            char x=str.charAt(i);
            if (x=='(' || x=='{' || x=='[')
                stack.push(x);
            else {
               if (stack.isEmpty()==true)
                   return false;
               else if (matching(stack.peek(),x)==false) {
                   return false;
               }
               else
                   stack.pop();
            }
        }
        return stack.isEmpty()==true;
    }

    static boolean matching(char a,char b){
        return ( (a=='(' && b==')') || (a=='{' && b=='}') || (a=='[' && b==']') );
    }
}
