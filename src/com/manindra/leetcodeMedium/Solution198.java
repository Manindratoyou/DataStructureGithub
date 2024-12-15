package com.manindra.leetcodeMedium;

public class Solution198 { //House Robber

    public static void main(String[] args) {

        int [] nums={2,7,9,3,1};
        int [] nums1={2,7,3,1,4,2,1,8}; //7 ,4 ,8
        int [] nums2={6,9,6}; //greedy approach will fail
        System.out.println(rob(nums));
        System.out.println(rob2(nums1));
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

    static int rob2(int [] nums){
        return robHelper(nums, 0); // Start the recursion from the first house
    }

    // Helper function for recursive approach
    static int robHelper(int[] nums, int index) {
        // Base case: If index is out of bounds, return 0
        if (index >= nums.length)
            return 0;

        // Case 1: Rob current house and skip next house
        int include = nums[index] + robHelper(nums, index + 2);

        // Case 2: Skip current house and move to next house
        int exclude = robHelper(nums, index + 1);

        // Return the maximum loot for the current state
        return Math.max(include, exclude);
    }
}
