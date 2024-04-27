package com.manindra.stack_ds;

import java.util.Stack;

public class StackWithGetMinimumTwo { //stack with get min in 0(1) space

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(4);
        stack.push(5);
        stack.push(8);
        stack.push(1);
        stack.push(3);

         stack.pop();
         stack.pop();
        System.out.println(stack.peek());

        System.out.println("Minimum element in the stack: " + stack.getMin());
    }

    static class MyStack {
        Stack<Integer> stack;
        int min;

        MyStack() {
            stack = new Stack<>();
        }

        void push(int x){
            if (stack.isEmpty()){
                min=x;
                stack.add(x);
            } else if (x<=min) {
                stack.add(x-min);
                min=x;
            }else
                stack.add(x);
        }

        int pop(){
            int t=stack.peek();
            stack.pop();
            if (t<=0){
                int result=min;
                min=min-t;
                return result;
            }else
                return t;
        }

        int peek(){
            int t=stack.peek();

            return ((t==0) ? min : t);
        }

        int getMin(){
            return min;
        }
    }
}
