package com.manindra.heap_ds_leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxProductOfTwoElements { //solution 1464

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 2};
        System.out.println(maxProduct(nums)); // Output: 12
    }

    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);  // Sort the array in ascending order
        int n = nums.length;
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }

    //One-Pass (Optimal — No Sort)
    public static int maxProduct2(int[] nums) {
        int firstMax = 0;
        int secondMax = 0;

        for (int num : nums) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }

        return (firstMax - 1) * (secondMax - 1);
    }

    public static int maxProduct3(int[] nums) {
        // Max-heap: we use reverse order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements to the heap
        for (int num : nums) {
            maxHeap.add(num);
        }

        // Get the two largest elements
        int max1 = maxHeap.poll(); // largest
        int max2 = maxHeap.poll(); // second largest

        return (max1 - 1) * (max2 - 1);
    }
}

