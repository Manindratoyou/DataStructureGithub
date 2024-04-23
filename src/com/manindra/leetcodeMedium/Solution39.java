package com.manindra.leetcodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {

    public static void main(String[] args) {

        Solution39 solution = new Solution39();

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = solution.combinationSum(candidates, target);

        System.out.println("Result: " + result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the candidates to handle duplicates

        backtrack(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remaining, int start) {
        if (remaining < 0) {
            return;
        } else if (remaining == 0) {
            result.add(new ArrayList<>(currentList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                currentList.add(candidates[i]);
                // Recursive call with updated remaining and start index
                backtrack(result, currentList, candidates, remaining - candidates[i], i);
                currentList.remove(currentList.size() - 1); // Backtrack
            }
        }
    }


}

