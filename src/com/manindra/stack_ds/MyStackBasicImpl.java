package com.manindra.stack_ds;

public class MyStackBasicImpl {

    int stackArray[];
    int capacity;
    int topIndex;

    MyStackBasicImpl(int capacity) {
        topIndex = -1;
        this.capacity = capacity;
        stackArray = new int[capacity];
    }

    void push(int element) {
        if (topIndex == capacity - 1) {
            System.out.println("Stack is full.");
            return;
        }
        topIndex++;
        stackArray[topIndex] = element;
    }

    int pop() {
        if (topIndex == -1) {
            System.out.println("Stack is empty.");
            return Integer.MIN_VALUE;
        }
        int poppedElement = stackArray[topIndex];
        topIndex--;
        return poppedElement;
    }

    int peek() {
        if (topIndex == -1) {
            System.out.println("Stack is empty.");
            return Integer.MIN_VALUE;
        }
        return stackArray[topIndex];
    }

    int size() {
        return topIndex + 1;
    }

    boolean isEmpty() {
        return topIndex == -1;
    }

    public static void main(String[] args) {
        MyStackBasicImpl stack = new MyStackBasicImpl(5);
        stack.push(5);
        stack.push(10);
        stack.push(15);
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Size of stack: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
