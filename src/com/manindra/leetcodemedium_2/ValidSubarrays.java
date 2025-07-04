package com.manindra.leetcodemedium_2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidSubarrays { //solution 1063

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 5, 3};
        int[] nums1 = {0,3,4,1,5};
        System.out.println(validSubarrays(nums)); // Output: 11
        System.out.println(validSubarrays2(nums1));
    }

    public static int validSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        //Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Maintain increasing stack: pop elements > current
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                stack.pop();
            }

            stack.push(i);
            count += stack.size();
        }

        return count;
    }

    public static int validSubarrays2(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int min = nums[i]; // Track the last element of subarray
            for (int j = i; j < n; j++) {
                // if current element is >= last element
                if (nums[j] >= min) {
                    count++;
                    min = Math.min(min, nums[j]); // update min for next iteration
                } else {
                    break; // once we find a smaller element, subarray is invalid
                }
            }
        }

        return count;
    }
}

