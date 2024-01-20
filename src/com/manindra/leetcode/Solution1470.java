package com.manindra.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 */
public class Solution1470 {

    public static void main(String[] args) {
        int [] nums = {2,5,1,3,4,7}; int  n = 3;
        System.out.println(Arrays.toString(shuffle(nums,n)));

    }

    //Time Complexity: O(n)
    //Auxiliary Space: O(n)
    static int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];

        for (int i = 0, j = 0; i < n; i++, j += 2) {
            result[j] = nums[i];
            result[j + 1] = nums[i + n];
        }

        return result;
    }

    public int[] shuffleSolutionTwo(int[] nums, int n) {
        return IntStream.range(0, n)
                .flatMap(i -> IntStream.of(nums[i], nums[i + n]))
                .toArray();
    }
}
