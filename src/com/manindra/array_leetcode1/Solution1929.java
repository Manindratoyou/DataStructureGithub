package com.manindra.array_leetcode1;

/*
Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
- ans = [1,2,1,1,2,1]
 */
public class Solution1929 { //Concatenation of Array

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] concatenatedArray = getConcatenation(nums);

        System.out.print("Concatenated Array: ");
        for (int num : concatenatedArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] result = new int[2 * n];

        for (int i = 0; i < n; i++) {
            result[i] = nums[i];
            result[i + n] = nums[i];
        }

        return result;
    }

}
