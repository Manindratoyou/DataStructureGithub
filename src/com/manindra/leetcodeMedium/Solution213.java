package com.manindra.leetcodeMedium;

public class Solution213 {

    public static void main(String[] args) {
        int [] nums={1,2,3,1};
        System.out.println(rob(nums));

    }

    static int rob(int [] nums){
        if (nums.length<2)
            return nums[0];

        //create two new array
        int [] skipLastHouse=new int[nums.length];
        int [] skipFirstHouse=new int[nums.length];

        for (int i=0;i< nums.length-1;i++){
            skipLastHouse[i]=nums[i];
            skipFirstHouse[i]=nums[i+1];
        }

        //get the loot from both the possibility
        int lootSkippingLast=robHelper(skipLastHouse);
        int lootSkippingFirst=robHelper(skipFirstHouse);

        return Math.max(lootSkippingFirst,lootSkippingLast);

    }

    static int robHelper(int [] nums){

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
