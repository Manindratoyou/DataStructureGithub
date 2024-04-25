package com.manindra.stack_ds;

import java.util.Stack;

public class StackWithGetMinimum { //stack with get min in 0(1) time

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(4);
        stack.push(5);
        stack.push(8);
        stack.push(1);
        stack.push(3);
        // stack.pop(); // You may uncomment this line to test pop operation
        System.out.println("Minimum element in the stack: " + stack.getMin());
    }

    static class MyStack {
        Stack<Integer> mainStack;
        Stack<Integer> auxiliaryStack;

        MyStack() {
            mainStack = new Stack<>();
            auxiliaryStack = new Stack<>();
        }

        void push(int x) {
            mainStack.push(x);
            if (auxiliaryStack.isEmpty() || x <= auxiliaryStack.peek()) {
                auxiliaryStack.push(x);
            }
        }

        int pop() {
            if (mainStack.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            int popped = mainStack.pop();
            if (popped == auxiliaryStack.peek()) {
                auxiliaryStack.pop();
            }
            return popped;
        }

        int getMin() {
            if (auxiliaryStack.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return auxiliaryStack.peek();
        }
    }
}
