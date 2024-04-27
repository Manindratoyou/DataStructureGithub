package com.manindra.stack_ds;

import java.util.Stack;

public class StackWithGetMinimumTwoSolution2 {

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
        Stack<Integer> dataStack;
        int min;

        MyStack() {
            dataStack = new Stack<>();
        }

        void push(int x){
            if (dataStack.isEmpty()){
                min=x;
                dataStack.add(x);
            } else if (x<=min) {
                dataStack.add(2*x-min);
                min=x;
            }else {
                dataStack.add(x);
            }
        }

        int pop(){
            int t=dataStack.peek();
            dataStack.pop();
            if (t<=0){
                int result=min;
                min=2*min-t;
                return result;
            }else
                return t;
        }

        int peek(){
            int t=dataStack.peek();
            return ((t<=0) ? min : t);
        }

        int getMin(){
            return min;
        }
    }
}
