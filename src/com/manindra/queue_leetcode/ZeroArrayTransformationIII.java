package com.manindra.queue_leetcode;

import java.util.*;

public class ZeroArrayTransformationIII { //solution 3362
    public static void main(String[] args) {
        ZeroArrayTransformationIII solution = new ZeroArrayTransformationIII();

        int[] nums1 = {2, 0, 2};
        int[][] queries1 = {{0, 2}, {0, 2}, {1, 1}};
        System.out.println(solution.maxRemoval(nums1, queries1)); // Output: 1

        int[] nums2 = {1, 1, 1, 1};
        int[][] queries2 = {{1, 3}, {0, 2}, {1, 3}, {1, 2}};
        System.out.println(solution.maxRemoval(nums2, queries2)); // Output: 2

        int[] nums3 = {1, 2, 3, 4};
        int[][] queries3 = {{0, 3}};
        System.out.println(solution.maxRemoval(nums3, queries3)); // Output: -1

        int[] nums4 = {0, 0, 1, 1, 0};
        int[][] queries4 = {{3, 4}, {0, 2}, {2, 3}};
        System.out.println(solution.maxRemoval(nums4, queries4)); // Output: 2
    }

    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        // Sort queries by start index
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));

        // Max-heap for available queries (by end index)
        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap for running queries (by end index)
        PriorityQueue<Integer> running = new PriorityQueue<>();

        int queryIndex = 0;
        int usedQueries = 0;

        for (int i = 0; i < n; i++) {
            // Add all queries starting at i to available heap
            while (queryIndex < q && queries[queryIndex][0] == i) {
                available.offer(queries[queryIndex][1]);
                queryIndex++;
            }

            // Remove queries from running heap that have ended before i
            while (!running.isEmpty() && running.peek() < i) {
                running.poll();
            }

            // Apply queries to cover nums[i]
            while (nums[i] > running.size()) {
                // Remove expired queries from available heap
                while (!available.isEmpty() && available.peek() < i) {
                    available.poll();
                }

                if (available.isEmpty()) {
                    return -1;
                }

                running.offer(available.poll());
                usedQueries++;
            }
        }

        return q - usedQueries;
    }
}

