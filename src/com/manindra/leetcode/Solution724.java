package com.manindra.leetcode;

/*
Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
 */
public class Solution724 {//Find Pivot Index

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println("Pivot Index: " + pivotIndexSolutionOne(nums));
        System.out.println("Pivot Index: " + pivotIndexSolutionTwo(nums));
        System.out.println("Pivot Index: " + pivotIndexSolutionThree(nums));
    }

    public static int pivotIndexSolutionOne(int[] nums) {

        int n=nums.length;
        int [] prefixSum=new int[n];
        int  [] suffixSum=new int[n];

        prefixSum[0]=nums[0];
        suffixSum[n-1]=nums[n-1];

        for (int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        for (int i=n-2;i>=0;i--){
            suffixSum[i]=suffixSum[i+1]+nums[i];
        }

        for (int i=0;i< n;i++){
            if (prefixSum[i]==suffixSum[i])
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

    public static int pivotIndexSolutionThree(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        int rightSum = totalSum;

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}
