package com.manindra.hashing_leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class LongestSubarrayDiffLimit { //solution 1438

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{8,2,4,7}, 4));       // Output: 2
        System.out.println(longestSubarray(new int[]{10,1,2,4,7,2}, 5));  // Output: 4
        System.out.println(longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0)); // Output: 3
    }

    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0, result = 0;

        for (int right = 0; right < nums.length; right++) {
            // Maintain maxDeque (decreasing order)
            while (!maxDeque.isEmpty() && nums[right] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);

            // Maintain minDeque (increasing order)
            while (!minDeque.isEmpty() && nums[right] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);

            // Shrink window if condition violated
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[left]) maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[left]) minDeque.pollFirst();
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static int longestSubarray2(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, result = 0;

        for (int right = 0; right < nums.length; right++) {
            // Add current element to map
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // Shrink window if diff > limit
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }


}

