package com.manindra.sliding_window_leetcode;

public class MinimumSizeSubarraySum { //solution 209

    public static void main(String[] args) {
        // Test case
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int[] nums1 = {1, 4, 4};
        int target1 = 4; // op 1
        int[] nums2 = {1, 1, 1, 1, 1, 1, 1, 1};
        int target2 = 11; //op 0

        // Create an instance of the class and call the method
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        int result = solution.minSubArrayLen(target, nums);
        int result2 = solution.minSubArrayLenBrutForce(target, nums);

        // Print the result
        System.out.println("Minimum length of subarray with sum >= " + target + ": " + result);
        System.out.println("Minimum length of subarray with sum >= " + target + ": " + result2);

        System.out.println(minSubArrayLength2(nums1,target1));
    }

    static int minSubArrayLen(int target, int[] nums) {

        int minLenWindow = Integer.MAX_VALUE;
        int currentSum = 0;

        // Start 2 pointers sliding window
        int low = 0;
        int high = 0;
        while (high < nums.length) {

            // Find the current sum and increase window size
            currentSum += nums[high];
            high++;

            // Try to reduce the window size
            while (currentSum >= target) {

                int currentWindowSize = high - low;

                // Update minimum length of window
                minLenWindow = Math.min(minLenWindow, currentWindowSize);

                currentSum -= nums[low];
                low++;
            }
        }

        return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
    }

    static int minSubArrayLenBrutForce(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;

        // Check all subarrays
        for (int start = 0; start < n; start++) {
            int currentSum = 0;

            // Loop through the array to create subarrays starting from 'start'
            for (int end = start; end < n; end++) {
                currentSum += nums[end];

                // If current sum >= target, update minimum length
                if (currentSum >= target) {
                    minLen = Math.min(minLen, end - start + 1);
                    break; // No need to check further subarrays for this start point
                }
            }
        }

        // If minLen was not updated, no subarray found
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    static int minSubArrayLength2(int[] nums,int target) {
        int n = nums.length, window = 0, ans = Integer.MAX_VALUE, left = 0;
        for (int right = 0; right < n; right++) {
            window += nums[right];
            while (window >= target) {
                ans = Math.min(ans, right - left + 1);
                window -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
