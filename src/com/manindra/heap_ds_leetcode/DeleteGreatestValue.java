package com.manindra.heap_ds_leetcode;

import java.util.*;

public class DeleteGreatestValue { //solution 2500

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 4},
                {3, 3, 1}
        };
        //System.out.println(deleteGreatestValue(grid)); // Output: 8
        System.out.println(deleteGreatestValue2(grid)); // Output: 8
    }

    public static int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Sort each row in ascending order
        for (int[] row : grid) {
            Arrays.sort(row);
        }

        int result = 0;

        // Step 2: Iterate column-wise from right to left (largest elements at end of each row)
        for (int col = n - 1; col >= 0; col--) {
            int maxInCol = 0;
            for (int row = 0; row < m; row++) {
                maxInCol = Math.max(maxInCol, grid[row][col]);
            }
            result += maxInCol;
        }

        return result;
    }

    public static int deleteGreatestValue2(int[][] grid) {
        int m = grid.length;

        // Create a list of max-heaps (priority queues) for each row
        List<PriorityQueue<Integer>> maxHeaps = new ArrayList<>();

        for (int[] row : grid) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            for (int num : row) {
                maxHeap.offer(num);
            }
            maxHeaps.add(maxHeap);
        }

        int result = 0;

        // Perform operations until all heaps are empty
        while (!maxHeaps.get(0).isEmpty()) {
            int maxInRound = 0;
            for (PriorityQueue<Integer> heap : maxHeaps) {
                maxInRound = Math.max(maxInRound, heap.poll());
            }
            result += maxInRound;
        }

        return result;
    }
}
