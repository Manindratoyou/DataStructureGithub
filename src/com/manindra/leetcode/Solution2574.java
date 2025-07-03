package com.manindra.leetcode;

import java.util.Arrays;

/*
Input: nums = [10,4,8,3]
Output: [15,1,11,22]
Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].
 */
public class Solution2574 { //Left and Right Sum Differences

    public static void main(String[] args) { //similar to 1991

        int[] arr = {10, 4, 8, 3};
        //System.out.println(Arrays.toString(leftRightDifference(arr)));
        System.out.println(Arrays.toString(leftRightDifferenceSolutionTwo(arr)));
    }

    static int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        prefixSum[0] = nums[0];
        suffixSum[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(prefixSum[i] - suffixSum[i]);
        }
        return nums;
    }

    static int[] leftRightDifferenceSolutionTwo(int[] nums) {

        int rightSum = 0;
        int leftSum = 0;

        // Calculate the total right sum
        for (int num : nums) {
            rightSum += num;
        }

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Get the value at index i
            int val = nums[i];

            // Update the right sum
            rightSum -= val;

            // Find the difference
            nums[i] = Math.abs(leftSum - rightSum);

            // Update the left sum
            leftSum += val;
        }

        return nums;
    }

}
