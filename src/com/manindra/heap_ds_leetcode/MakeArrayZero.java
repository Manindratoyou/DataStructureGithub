package com.manindra.heap_ds_leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MakeArrayZero { //solution 2357

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 0, 3, 5};  // Output: 3
        int[] nums2 = {0};              // Output: 0
        int[] nums3 = {4, 4, 4};        // Output: 1

        System.out.println(minimumOperations(nums1));
        System.out.println(minimumOperations(nums2));
        System.out.println(minimumOperations(nums3));
    }

    public static int minimumOperations(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add only positive elements to the heap
        for (int num : nums) {
            if (num > 0) minHeap.offer(num);
        }

        int operations = 0;
        int prev = -1;

        // Remove duplicates and count operations
        while (!minHeap.isEmpty()) {
            int current = minHeap.poll();
            if (current != prev) {
                operations++;
                prev = current;
            }
        }

        return operations;
    }

    public static int minimumOperations2(int[] nums) {
        Arrays.sort(nums);
        int operations = 0;
        int prev = 0;

        for (int num : nums) {
            if (num > 0 && num != prev) {
                operations++;
                prev = num;
            }
        }

        return operations;
    }

    public static int minimumOperations3(int[] nums) {
        return (int) Arrays.stream(nums)
                .filter(num -> num > 0)
                .distinct()
                .count();
    }

    public static int minimumOperations4(int[] nums) {
        Set<Integer> uniquePositives = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                uniquePositives.add(num);
            }
        }
        return uniquePositives.size();
    }


}
