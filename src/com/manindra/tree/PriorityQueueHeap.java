package com.manindra.tree;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueHeap {

    // Main Method to Demonstrate Operations
    public static void main(String[] args) {
        // Min-Heap Demonstration
        minHeapDemo();

        // Max-Heap Demonstration
        maxHeapDemo();

        // Heap Sort Demonstration
        int[] arr = {15, 10, 20, 5, 25, 30};
        heapSortDemo(arr, false); // Min-Heap for ascending order
        heapSortDemo(arr, true);  // Max-Heap for descending order
    }

    // Min-Heap Operations
    public static void minHeapDemo() {
        System.out.println("Min-Heap Operations:");

        // Create a Min-Heap (Default PriorityQueue behavior)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert elements
        minHeap.offer(10);
        minHeap.offer(20);
        minHeap.offer(5);
        minHeap.offer(7);
        minHeap.offer(25);

        // Print the Min-Heap
        System.out.println("Min-Heap: " + minHeap);

        // Peek at the smallest element
        System.out.println("Peek Min: " + minHeap.peek());

        // Extract elements in sorted order (ascending)
        while (!minHeap.isEmpty()) {
            System.out.println("Extracted Min: " + minHeap.poll());
        }
    }

    // Max-Heap Operations
    public static void maxHeapDemo() {
        System.out.println("\nMax-Heap Operations:");

        // Create a Max-Heap using Collections.reverseOrder()
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Insert elements
        maxHeap.offer(10);
        maxHeap.offer(20);
        maxHeap.offer(5);
        maxHeap.offer(7);
        maxHeap.offer(25);

        // Print the Max-Heap
        System.out.println("Max-Heap: " + maxHeap);

        // Peek at the largest element
        System.out.println("Peek Max: " + maxHeap.peek());

        // Extract elements in sorted order (descending)
        while (!maxHeap.isEmpty()) {
            System.out.println("Extracted Max: " + maxHeap.poll());
        }
    }

    // Generic Heap Sort Using PriorityQueue
    public static void heapSortDemo(int[] arr, boolean isMaxHeap) {
        System.out.println("\nHeap Sort (" + (isMaxHeap ? "Descending" : "Ascending") + "):");

        // Create a heap based on the flag (Min-Heap or Max-Heap)
        PriorityQueue<Integer> heap = isMaxHeap
                ? new PriorityQueue<>(Collections.reverseOrder())
                : new PriorityQueue<>();

        // Insert all elements into the heap
        for (int num : arr) {
            heap.offer(num);
        }

        // Extract elements to sort the array
        while (!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
        System.out.println();
    }
}

