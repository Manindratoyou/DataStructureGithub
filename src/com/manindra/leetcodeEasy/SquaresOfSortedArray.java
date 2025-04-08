package com.manindra.leetcodeEasy;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public static void main(String[] args) { //solution 977

        int[] nums = {-4, -1, 0, 3, 10};
        //int [] result=sortedSquares(nums);
        int[] result = sortedSquares3(nums);
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

    static int[] sortedSquares2(int[] nums) { // O(n log n)
        int[] arr = Arrays.stream(nums).map(i -> i * i).toArray();
        Arrays.sort(arr);
        return arr;
    }

    static int[] sortedSquares3(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[i] = nums[l] * nums[l];
                l++;
            } else {
                res[i] = nums[r] * nums[r];
                r--;
            }
        }
        return res;
    }


}
