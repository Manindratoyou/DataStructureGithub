package com.manindra.dynamicprogramming_leetcode;

public class Solution53 { //max sum sub array

    public static void main(String[] args) {
        int [] arr={2,3,-8,7,-1,2,3};
        System.out.println(maxSumSubArray(arr,arr.length));
        System.out.println(maxSubArray(arr));
    }

    static int maxSumSubArray(int [] arr, int n){
        int result=arr[0];
        int maxEnding=arr[0];
        for (int i=1;i<n;i++){
            maxEnding=Math.max(maxEnding+arr[i],arr[i]);
            result=Math.max(result,maxEnding);
        }
        return result;
    }
    static int maxSubArray(int[] nums) {

        int max_so_far = nums[0];
        int curr_max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curr_max = Math.max(nums[i], nums[i] + curr_max);
            max_so_far = Math.max(curr_max, max_so_far);
        }

        return max_so_far;
    }

}
