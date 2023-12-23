package com.manindra.leetcodeMedium;

import java.util.ArrayList;
import java.util.List;


//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
public class Solution78 { //subsets

    public static void main(String[] args) {
        int [] nums={1,2,3};
        List<List<Integer>> result=subsets(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        // Start backtracking from the beginning
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    static void backtrack(List<List<Integer>> resultSets, List<Integer> tempSet,
                           int[] nums, int start) {
        // Add the set to result set
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

    static List<List<Integer>> subSets(int [] nums){

        List<List<Integer>> result=new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num: nums){
            int n=result.size();
            for (int j=0;j<n;j++){
                List<Integer> temp=new ArrayList<>(result.get(j));
                temp.add(num);
                result.add(temp);
            }
        }
        return result;
    }
}
