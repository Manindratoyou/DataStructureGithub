package com.manindra.leetcode;

import java.util.Arrays;

/*
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class Solution905 { //Sort Array By Parity

    public static void main(String[] args) {

        int [] nums = {3,1,2,4};
        //int[]  result=sortArrayByParity(nums);
        int[]  result=sortArrayByParitySolTwo(nums);
        System.out.println(Arrays.toString(result));
    }

    static int[] sortArrayByParity(int[] nums) {
        int nonZeroIndex=0;
        for (int i=0;i< nums.length;i++){
            if (nums[i]%2==0){
                int temp=nums[nonZeroIndex];
                nums[nonZeroIndex]=nums[i];
                nums[i]=temp;
                nonZeroIndex++;
            }
        }
        return nums;
    }

    static int[] sortArrayByParitySolTwo(int[] nums) {
        int[] result = new int[nums.length];
        int evenIndex = 0;
        int oddIndex = nums.length - 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                result[evenIndex++] = num;
            } else {
                result[oddIndex--] = num;
            }
        }

        return result;
    }
}
