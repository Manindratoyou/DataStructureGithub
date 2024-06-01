package com.manindra.heap_ds;

import java.util.Comparator;
import java.util.PriorityQueue;

public class K_Closest_Element2 {

    public static void main(String[] args) {

        int[] arr = {10, 15, 7, 3, 4};
        int target = 8;
        int numClosest = 2;
        printKClosest(arr, numClosest, target);
    }

    static void printKClosest(int[] arr, int numClosest, int target) {
        /*PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });*/
        // Create a max heap using a priority queue
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // Add the first numClosest elements to the heap
        for (int i = 0; i < numClosest; i++) {
            maxHeap.offer(new Pair(arr[i], Math.abs(arr[i] - target)));
        }

        // Process the remaining elements
        for (int i = numClosest; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - target);
            // If the current difference is less than the max difference in the heap
            if (maxHeap.peek().getValue() > diff) {
                maxHeap.poll(); // Remove the element with the max difference
                maxHeap.offer(new Pair(arr[i], diff)); // Add the current element
            }
        }

        // Print the k closest elements
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll().getKey() + " ");
        }
    }

    static class Pair {

        Integer key;
        Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
