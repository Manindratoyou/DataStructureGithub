package com.manindra.util;

import java.util.Stack;

class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.isEmpty() ? -1 : stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Testing QueueUsingStacks:");
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeue: " + queue.dequeue()); // 10
        System.out.println("Peek: " + queue.peek());       // 20
        System.out.println("Dequeue: " + queue.dequeue()); // 20
        System.out.println("Dequeue: " + queue.dequeue()); // 30
        System.out.println("Is Empty: " + queue.isEmpty()); // true
    }
}

