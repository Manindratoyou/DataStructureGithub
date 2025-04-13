package com.manindra.heap_ds_hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/minimum-sum-11/problem
public class MinimumSum10 {

    public static void main(String[] args) {
        List<Integer> nums1 = Arrays.asList(10, 20, 7);
        System.out.println(minSum(nums1, 4)); // Output: 14

        List<Integer> nums2 = Arrays.asList(2);
        System.out.println(minSum(nums2, 1)); // Output: 1

        List<Integer> nums3 = Arrays.asList(2, 3);
        System.out.println(minSum(nums3, 1)); // Output: 4
    }

    public static int minSum(List<Integer> nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements to max heap
        maxHeap.addAll(nums);

        while (k-- > 0) {
            int max = maxHeap.poll();
            int reduced = (int) Math.ceil(max / 2.0);
            maxHeap.add(reduced);
        }

        // Sum all remaining elements
        int totalSum = 0;
        while (!maxHeap.isEmpty()) {
            totalSum += maxHeap.poll();
        }

        return totalSum;
    }

    public static int minSum2(List<Integer> nums, int k) {
        PriorityQueue<Integer> maxHeap = nums.stream().
                collect(Collectors.toCollection(() ->
                        new PriorityQueue<>(Collections.reverseOrder())));

        for (int i = 0; i < k; i++) {
            int max = maxHeap.poll();
            maxHeap.add((int) Math.ceil(max / 2.0));
        }

        return maxHeap.stream().mapToInt(Integer::intValue).sum();
    }

}
