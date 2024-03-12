package com.manindra.leetcodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {

    /*
    Given an integer array nums that may contain duplicates, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
     */

    public static void main(String[] args) {
        int [] nums={2,1,2};
        Solution90 solution=new Solution90();
        System.out.println(solution.subsetsWithDup(nums));

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);

        // Start backtracking from the beginning
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultSets, List<Integer> tempSet,
                           int[] nums, int start) {
        // If the set is already present, just continue
        if (resultSets.contains((tempSet)))
            return;

        resultSets.add(new ArrayList<>(tempSet));

        for (int i = start; i < nums.length; i++) {
            // Case of including the number
            tempSet.add(nums[i]);

            // Backtrack the new subset
            backtrack(resultSets, tempSet, nums, i + 1);

            // Case of not-including the number
            tempSet.remove(tempSet.size() - 1);
        }
    }

}
