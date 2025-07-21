package com.manindra.array_leetcode2;

public class NumberOfSubarraysThreshold { //solution 1343

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4, 1, 2, 1, 5, 1};
        int[] nums1 = {2,2,2,2,5,5,5,8};
        int k = 3, threshold = 3;
        int k1 = 3, threshold1 = 4;
        System.out.println(numOfSubarrays(nums1, k1, threshold1));
    }

    static int numOfSubarrays(int[] nums, int k, int threshold) {
        int n = nums.length;
        int sum = 0, count = 0;
        int target = k * threshold;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            if (right >= k) {
                sum -= nums[right - k];
            }

            if (right >= k - 1 && sum >= target) {
                count++;
            }
        }

        return count;
    }

}
