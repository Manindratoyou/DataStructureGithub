package com.manindra.leetcodemedium_2;

public class MinimumSizeSubarraySum { //solution 209

    public static void main(String[] args) {
        // Test case
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        // Create an instance of the class and call the method
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        int result = solution.minSubArrayLen(target, nums);

        // Print the result
        System.out.println("Minimum length of subarray with sum >= " + target + ": " + result);
    }

    static int minSubArrayLen(int target, int[] nums) {

        int minLenWindow = Integer.MAX_VALUE;
        int currentSum = 0;

        // Start 2 pointers sliding window
        int low = 0;
        int high = 0;
        while(high < nums.length) {

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
}
