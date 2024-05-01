package com.manindra.queue_ds;

import java.util.LinkedList;
import java.util.Queue;

public class ImpStackUsingQueue {

    public static void main(String[] args) {
        Stack stack = new Stack();

        // Push elements into the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display the top element
        System.out.println("Top element: " + stack.top());

        // Pop an element
        stack.pop();

        // Display the top element after popping
        System.out.println("Top element after popping: " + stack.top());

        // Display the size of the stack
        System.out.println("Size of stack: " + stack.size());
    }

    static class Stack {

        static Queue<Integer> queue1 = new LinkedList<>();
        static Queue<Integer> queue2 = new LinkedList<>();
        static int current_size;

        Stack() {
            current_size = 0;
        }

        static void push(int x) {
            current_size++;
            queue2.add(x);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.peek());
                queue1.remove();
            }
            Queue<Integer> queue = queue1;
            queue1 = queue2;
            queue2 = queue;
        }

        static void pop() {
            if (queue1.isEmpty())
                return;
            queue1.remove();
            current_size--;
        }

        static int top() {
            if (queue1.isEmpty())
                return -1;
            return queue1.peek();
        }

        static int size() {
            return current_size;
        }
    }
}
