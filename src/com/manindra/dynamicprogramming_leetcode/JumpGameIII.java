package com.manindra.dynamicprogramming_leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII { //solution 1306

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {4, 2, 3, 0, 3, 1, 2};
        int start1 = 5;
        System.out.println("Test Case 1: " + canReach(arr1, start1)); // Expected output: true

        // Test case 2
        int[] arr2 = {4, 2, 3, 0, 3, 1, 2};
        int start2 = 0;
        System.out.println("Test Case 2: " + canReach(arr2, start2)); // Expected output: true

        // Test case 3
        int[] arr3 = {3, 0, 2, 1, 2};
        int start3 = 2;
        System.out.println("Test Case 3: " + canReach(arr3, start3)); // Expected output: false
    }

    static boolean canReach(int[] arr, int start) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();

            // reached the target index
            if (arr[curr] == 0)
                return true;

            // negative means we already tried it
            if (arr[curr] < 0)
                continue;

            // Try both directions
            if (curr + arr[curr] < arr.length) q.add(curr + arr[curr]);

            if (curr - arr[curr] >= 0) q.add(curr - arr[curr]);

            // mark this element as visited
            arr[curr] = -arr[curr];
        }

        return false;
    }
}
