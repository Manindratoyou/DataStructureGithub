package com.manindra.heap_ds;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueJava {

    public static void main(String[] args) {

        //PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        //PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(Comparator.reverseOrder());
        //Queue<Integer> priorityQueue=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(Collections.reverseOrder());

        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(15);

        // Display the highest priority element without removing it
        System.out.println(priorityQueue.peek()); // Outputs: 20

        // Remove and display the highest priority element
        System.out.println(priorityQueue.poll()); // Outputs: 20

        // Display the highest priority element again without removing it
        System.out.println(priorityQueue.peek()); // Outputs: 15

        //==========================================================//


        // Add more elements to the priority queue
        priorityQueue.add(5);
        priorityQueue.add(25);

        // Print the entire priority queue
        System.out.println("Priority Queue: " + priorityQueue); // Outputs the elements in heap order

        // Check if an element is present in the priority queue
        System.out.println("Contains 15? " + priorityQueue.contains(15)); // Outputs: true

        // Remove a specific element
        priorityQueue.remove(15);
        System.out.println("Priority Queue after removing 15: " + priorityQueue); // 15 is removed

        // Get the size of the priority queue
        System.out.println("Size of Priority Queue: " + priorityQueue.size()); // Outputs the size

        // Clear the priority queue
        priorityQueue.clear();
        System.out.println("Priority Queue after clear: " + priorityQueue); // Outputs: []
    }
}
