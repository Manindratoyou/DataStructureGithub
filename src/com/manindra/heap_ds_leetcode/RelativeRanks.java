package com.manindra.heap_ds_leetcode;

import java.util.*;

public class RelativeRanks { //solution 506

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // Max Heap based on score value
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{score[i], i}); // store [score, index]
        }

        int rank = 1;
        while (!pq.isEmpty()) {
            int[] entry = pq.poll();
            int index = entry[1];

            if (rank == 1) {
                result[index] = "Gold Medal";
            } else if (rank == 2) {
                result[index] = "Silver Medal";
            } else if (rank == 3) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank);
            }
            rank++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] scores = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(findRelativeRanks(scores)));
        // Output: ["Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"]
    }
}

