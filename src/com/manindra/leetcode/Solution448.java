package com.manindra.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution448 { //findDisappearedNumbers

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 1}; //[5, 6]
        int[] nums2 = {1, 1, 1}; //[2, 3]
        List<Integer> result = findDisapprearedNumber(nums);
        System.out.println(result);
        System.out.println("========");
        List<Integer> result2 = findDisapprearedNumberSolutionTwo(nums2);
        System.out.println(result2);

    }

    //solution 1 : using extra space (hashset) TC:O(n) AS:O(n)
    public static List<Integer> findDisapprearedNumber(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!numSet.contains(i))
                result.add(i);
        }
        return result;
    }

    //solution 2 : In place modification TC: O(n) AS: 0(1)
    public static List<Integer> findDisapprearedNumberSolutionTwo(int[] nums) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0)
                nums[index] = -nums[index];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                result.add(i + 1);
        }
        return result;
    }
}
