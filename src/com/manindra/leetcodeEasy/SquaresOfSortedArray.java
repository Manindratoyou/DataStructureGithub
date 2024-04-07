package com.manindra.leetcodeEasy;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public static void main(String[] args) { //solution 977

        int[] nums = {-4, -1, 0, 3, 10};
        int [] result=sortedSquares(nums);
        System.out.println(Arrays.toString(result));

    }

    static int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];

        //square all element
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int head = 0;
        int tail = nums.length - 1;

        //set them at right place in the result array
        for (int pos = nums.length - 1; pos >= 0; pos--) {
            if (nums[head] > nums[tail]) {
                result[pos] = nums[head];
                //increment head pointer
                head++;
            } else {
                result[pos] = nums[tail];
                //increment tail pointer
                tail--;
            }
        }
        return result;
    }


}
