package com.manindra.dynamicprogramming_leetcode;

public class MaximumLengthOfRepeatedSubarray { //solution 718

    public static void main(String[] args) {

        int [] nums1 = {1,2,3,2,1}, nums2 = {3,2,1,4,7};
        System.out.println(findLength(nums1,nums2));

    }

    static int findLength(int[] nums1, int[] nums2) {

        int [] [] dp=new int[nums1.length+1][nums2.length+1];

        int max=0;

        //iterate over each position in the matrix
        for (int i=1;i<=nums1.length;i++){
            for (int j=1;j<= nums2.length;j++){

                //if numbers are equal
                if(nums1[i-1]==nums2[j-1]){
                    //get the number from diagonally opposite and add 1
                    dp[i][j]=dp[i-1][j-1]+1;

                    max=Math.max(dp[i][j],max);
                }
            }
        }
        return max;
    }

}
