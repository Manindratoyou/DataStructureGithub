package com.manindra.queue_ds;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseAQueue {

    public static void main(String[] args) {
        // Creating a sample queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("Original queue:");
        print(queue); // Displaying the original queue

        System.out.println("\nReversed queue (iterative):");
        reverseQueue(queue); // Reversing the queue using the iterative approach
        print(queue); // Displaying the reversed queue

        System.out.println("\nReversed queue (recursive):");
        reverseQueueSolutionTwo(queue); // Reversing the queue using the recursive approach
        print(queue); // Displaying the reversed queue
    }

    static void reverseQueue(Queue<Integer> queue) { // Iterative solution
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        while (!queue.isEmpty()) {
            stack.add(queue.peek());
            queue.remove();
        }
        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }
    }

    static void reverseQueueSolutionTwo(Queue<Integer> queue) { // Recursive solution
        if (queue.isEmpty())
            return;
        int x = queue.peek();
        queue.remove();
        reverseQueueSolutionTwo(queue);
        queue.add(x);
    }

    static void print(Queue<Integer> queue) {
        for (Integer x : queue) {
            System.out.print(x + " ");
        }
    }
}
