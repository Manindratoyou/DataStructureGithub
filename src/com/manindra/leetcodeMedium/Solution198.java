package com.manindra.leetcodeMedium;

public class Solution198 { //House Robber

    public static void main(String[] args) {

        int [] nums={2,7,9,3,1};
        System.out.println(rob(nums));
    }

    static int rob(int [] nums){

        //if only one element just return it
        if (nums.length<2)
            return nums[0];

        //create array to store the maximum loot at each index
        int [] dp=new int[nums.length];

        //memoize maximum loot at first 2 index
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        //use them to fill complete array
        for (int i=2;i< nums.length;i++){
            //core logic
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[nums.length-1];
    }
}
