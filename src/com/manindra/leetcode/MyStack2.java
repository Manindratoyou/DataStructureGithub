package com.manindra.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 { //solution 225 second

    public static void main(String[] args) {
        MyStack2 stack = new MyStack2();

        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(9);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

        stack.push(8);
        System.out.println(stack.top());
        System.out.println(stack.empty());
    }

    private Queue<Integer> queue;

    public MyStack2() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++)
            queue.add(queue.remove());

    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
