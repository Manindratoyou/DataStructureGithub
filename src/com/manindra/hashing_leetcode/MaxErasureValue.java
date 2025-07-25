package com.manindra.hashing_leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaxErasureValue { //solution 1695

    public static void main(String[] args) {
        int[] nums1 = {4, 2, 4, 5, 6};
        int[] nums2 = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        System.out.println(maximumUniqueSubarray(nums1)); // Output: 17
        System.out.println(maximumUniqueSubarray2(nums1)); // Output: 17
        System.out.println(maximumUniqueSubarray(nums2)); // Output: 8
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int left = 0, right = 0, maxSum = 0, currentSum = 0;
        HashSet<Integer> seen = new HashSet<>();

        while (right < nums.length) {
            while (seen.contains(nums[right])) {
                seen.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
            seen.add(nums[right]);
            currentSum += nums[right];
            maxSum = Math.max(maxSum, currentSum);
            right++;
        }

        return maxSum;
    }

    static int maximumUniqueSubarray2(int[] nums) { //
        int res = 0;
        int left = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            sum += nums[right];
            set.add(nums[right]);
            res = Math.max(res, sum);
        }
        return res;
    }

}

