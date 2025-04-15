package com.manindra.heap_ds_leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumNumberGame { //solution 2974

    public static void main(String[] args) {

        int[] nums = {5, 4, 2, 3};
        System.out.println(Arrays.toString(numberGame(nums)));
    }

    static int[] numberGame(int[] nums) {
        int[] result = new int[nums.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.add(num);
        }

        for (int i = 0; i < nums.length; i += 2) {
            int a = queue.poll();
            int b = queue.poll();
            result[i] = b;
            result[i + 1] = a;
        }

        return result;
    }
}
