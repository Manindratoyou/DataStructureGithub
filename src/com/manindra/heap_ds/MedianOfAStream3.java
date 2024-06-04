package com.manindra.heap_ds;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfAStream3 {

    public static void main(String[] args) {
        int[] inputNumbers = {25, 7, 10, 15, 20};
        printMedian(inputNumbers);
    }

    static void printMedian(int[] numbers) {
        // Max-heap for the smaller half of the numbers
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap for the larger half of the numbers
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert the first element into the max-heap
        maxHeap.add(numbers[0]);
        // Print the first median, which is the first element itself
        System.out.println(numbers[0]);

        // Iterate through the rest of the numbers
        for (int i = 1; i < numbers.length; i++) {
            int currentNumber = numbers[i];

            // Check which heap needs the current number
            if (maxHeap.size() > minHeap.size()) {
                if (currentNumber < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(currentNumber);
                } else {
                    minHeap.add(currentNumber);
                }
                // Print the median, which is the average of the two heap roots
                System.out.println((maxHeap.peek() + minHeap.peek()) / 2.0);
            } else {
                if (currentNumber <= maxHeap.peek()) {
                    maxHeap.add(currentNumber);
                } else {
                    minHeap.add(currentNumber);
                    maxHeap.add(minHeap.poll());
                }
                // Print the median, which is the root of the max-heap
                System.out.println(maxHeap.peek());
            }
        }
    }
}
