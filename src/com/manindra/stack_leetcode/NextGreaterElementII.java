package com.manindra.stack_leetcode;


import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII { //solution 503

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(result, -1);

        // Traverse twice to handle circular nature
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementII sol = new NextGreaterElementII();
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(sol.nextGreaterElements(nums)));  // [2, -1, 2]
    }
}

