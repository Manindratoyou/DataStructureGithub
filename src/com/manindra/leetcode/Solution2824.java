package com.manindra.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
Input: nums = [-1,1,2,3,1], target = 2
Output: 3
Explanation: There are 3 pairs of indices that satisfy the conditions in the statement:
- (0, 1) since 0 < 1 and nums[0] + nums[1] = 0 < target
- (0, 2) since 0 < 2 and nums[0] + nums[2] = 1 < target
- (0, 4) since 0 < 4 and nums[0] + nums[4] = 0 < target
Note that (0, 3) is not counted since nums[0] + nums[3] is not strictly less than the target.
 */
public class Solution2824 { //Count Pairs Whose Sum is Less than Target

    public static void main(String[] args) {

        int[] nums = {-1, 1, 2, 3, 1};
        int target = 2;
        System.out.println(countPairs1(nums, target));
        System.out.println("===");
        System.out.println(countPairs2(nums, target));
    }

    public static int countPairs1(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] < target) {
                    //System.out.println(i+" "+j);
                    count++;
                }
            }
        }
        return count;
    }


    public static int countPairs2(int[] nums, int target) { //Sort + Two Pointers (Efficient)
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int count = 0;

        while (left < right) {
            if (nums[left] + nums[right] < target) {
                count += (right - left); // all pairs (left, left+1..right)
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static int countPairs3(int[] nums, int target) {
        return (int) IntStream.range(0, nums.length)
                .flatMap(i -> IntStream.range(i + 1, nums.length)
                        .filter(j -> nums[i] + nums[j] < target))
                .count();
    }
}
