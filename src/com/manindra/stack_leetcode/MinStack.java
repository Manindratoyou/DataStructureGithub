package com.manindra.stack_leetcode;

import java.util.Stack;

public class MinStack { //solution 155

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int poppedValue = stack.pop();
        if (poppedValue == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        minStack.push(2);

        System.out.println("Current Min: " + minStack.getMin()); // 2
        System.out.println("Top Element: " + minStack.top());     // 2

        minStack.pop(); // Removes 2
        System.out.println("After pop - Current Min: " + minStack.getMin()); // 3
        System.out.println("After pop - Top Element: " + minStack.top());    // 7

        minStack.pop(); // Removes 7
        System.out.println("After another pop - Top: " + minStack.top());    // 3
        System.out.println("Min: " + minStack.getMin());                     // 3
    }
}

