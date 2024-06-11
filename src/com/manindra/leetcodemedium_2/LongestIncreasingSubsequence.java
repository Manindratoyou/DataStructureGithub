package com.manindra.leetcodemedium_2;

import java.util.Arrays;

public class LongestIncreasingSubsequence { //solution 300

    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        //System.out.println(longestIncreasingSubsequence(nums));
        System.out.println(lengthOfLIS(nums));
    }

    static int longestIncreasingSubsequence(int[] nums) {
        int[] T = new int[nums.length];

        //start main pointer
        for (int i = 1; i < nums.length; i++) {

            //start second pointer
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    if (T[j] + 1 > T[i])
                        T[i] = T[j] + 1;
            }
        }

        //find the max value
        int maxIndex = 0;
        for (int i = 0; i < T.length; i++) {
            if (T[i] > T[maxIndex])
                maxIndex = i;

        }
        return T[maxIndex] + 1;
    }

    static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            int ans=0;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    ans=Math.max(ans,dp[j]);
                }
            }
            dp[i]+=ans;
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
