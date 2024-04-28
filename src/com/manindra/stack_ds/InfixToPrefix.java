package com.manindra.stack_ds;

import java.util.Stack;

public class InfixToPrefix {

    public static void main(String[] args) {
        String expression="+9*26";
        System.out.println(evaluate(expression));
    }

    static boolean isOperand(char c){
        return Character.isDigit(c);
    }

    static int evaluate(String expression){
        Stack<Integer> stack=new Stack<>();
        for (int i=expression.length()-1;i>=0;i--){
            char c=expression.charAt(i);
            if (isOperand(c)){
                stack.push(c-'0');
            }else {
                int o1=stack.pop();
                int o2=stack.pop();
                if (c=='+')
                    stack.push(o1+o2);
                else if (c=='-') {
                    stack.push(o1-o2);
                } else if (c=='*') {
                    stack.push(o1*o2);
                }else if (c=='/')
                    stack.push(o1/o2);
            }
        }
        return stack.pop();
    }
}
