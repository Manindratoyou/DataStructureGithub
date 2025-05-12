package com.manindra.util;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        if (q1.isEmpty()) return -1;
        while (q1.size() > 1)
            q2.add(q1.remove());
        int top = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return top;
    }

    public int top() {
        if (q1.isEmpty()) return -1;
        while (q1.size() > 1)
            q2.add(q1.remove());
        int top = q1.peek();
        q2.add(q1.remove());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return top;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("\nTesting StackUsingQueues:");
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(5);
        stack.push(10);
        stack.push(15);

        System.out.println("Top: " + stack.top());     // 15
        System.out.println("Pop: " + stack.pop());     // 15
        System.out.println("Top: " + stack.top());     // 10
        System.out.println("Pop: " + stack.pop());     // 10
        System.out.println("Pop: " + stack.pop());     // 5
        System.out.println("Is Empty: " + stack.isEmpty()); // true
    }
}

