package com.manindra.array_leetcode1;

/*
Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
 */
public class Solution724 {//Find Pivot Index  // same as solution 1991

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 1, -1};
        System.out.println("Pivot Index: " + pivotIndexSolutionOne(nums));
        System.out.println("Pivot Index: " + pivotIndexSolutionOne(nums1));
        System.out.println("Pivot Index: " + pivotIndexSolutionOne(nums2));
        System.out.println("========================");
        System.out.println("Pivot Index: " + pivotIndexSolutionTwo(nums));
        System.out.println("Pivot Index: " + pivotIndexSolutionThree(nums));
    }

    public static int pivotIndexSolutionOne(int[] nums) {

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
            if (prefixSum[i] == suffixSum[i])
                return i;
        }

        return -1;
    }

    public static int pivotIndexSolutionTwo(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    static int pivotIndexSolutionThree(int[] nums) {

        // Calculate the sum of the array
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }

        int leftSum = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {

            // Update the right sum
            rightSum -= nums[i];

            // Check if the left sum is equal to the right sum
            if (leftSum == rightSum) {
                return i;
            }

            // Update the left sum
            leftSum += nums[i];
        }

        // Return -1 if no pivot index is found
        return -1;
    }
}
