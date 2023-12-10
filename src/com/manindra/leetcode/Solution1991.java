package com.manindra.leetcode;

public class Solution1991 { //question same as solution 724

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println("middle  Index: " + findMiddleIndex(nums));
    }

    public static int findMiddleIndex(int[] nums) {
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
}
