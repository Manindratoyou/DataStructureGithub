package com.manindra.heap_ds;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
A k-sorted array is an array where each element is at most k positions away from its target
position in a sorted array. The goal is to sort this array efficiently.
 */
public class Sort_K_Sorted_Array {  //Time Complexity: O(n log k)  \\Space Complexity: O(k)

    public static void main(String[] args) {

        int[] arr = {9, 8, 7, 18, 19, 17};
        int k = 2;
        sortK(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    static void sortK(int[] arr, int k) {
        // Create a Min-Heap (PriorityQueue)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add first k+1 elements to the heap
        for (int i = 0; i < k + 1; i++) {
            pq.add(arr[i]);
        }

        // Initialize index for the sorted portion of the array
        int index = 0;

        // Process the rest of the elements in the array
        for (int i = k + 1; i < arr.length; i++) {
            // Place the smallest element from the heap into the array
            arr[index++] = pq.poll();
            // Add the next element from the array into the heap
            pq.add(arr[i]);
        }

        // Extract remaining elements from the heap and place in the array
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
    }

}
