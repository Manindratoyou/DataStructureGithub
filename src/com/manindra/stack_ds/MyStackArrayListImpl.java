package com.manindra.stack_ds;

import java.util.ArrayList;

public class MyStackArrayListImpl {

    private ArrayList<Integer> stackList = new ArrayList<>();

    void push(int element) {
        stackList.add(element);
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return Integer.MIN_VALUE;
        }
        return stackList.remove(stackList.size() - 1);
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return Integer.MIN_VALUE;
        }
        return stackList.get(stackList.size() - 1);
    }

    int size() {
        return stackList.size();
    }

    boolean isEmpty() {
        return stackList.isEmpty();
    }

    public static void main(String[] args) {
        MyStackArrayListImpl stack = new MyStackArrayListImpl();
        stack.push(5);
        stack.push(10);
        stack.push(15);
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Size of stack: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
