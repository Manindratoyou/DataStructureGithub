package com.manindra.heap_ds_leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumProductAfterKIncrements { //solution 2233

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        int k = 3;

        int result = maximumProduct(nums, k);
        System.out.println("Maximum product after " + k + " increments: " + result);
    }

    static int maximumProduct(int[] nums, int k) {

        Queue<Integer> numPQ = new PriorityQueue<>();
        int mod = 1000000007;

        // Add all elements to priority queue
        for (int num : nums)
            numPQ.offer(num);

        for (int i = 0; i < k; i++) {
            // Get the minimum element and increment by 1
            int minElement = numPQ.remove();
            minElement++;

            // Add it back to the priority queue
            numPQ.offer(minElement);
        }

        // Find the product
        long result = 1;
        while (!numPQ.isEmpty()) {
            result *= numPQ.poll();
            result %= mod;
        }

        return (int) result;
    }

}
