package com.manindra.backtracking_leetcode;

public class SubsetXORSum { //solution 1863

    public static int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private static int dfs(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            return currentXor;
        }

        // Include current element
        int include = dfs(nums, index + 1, currentXor ^ nums[index]);

        // Exclude current element
        int exclude = dfs(nums, index + 1, currentXor);

        return include + exclude;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {5, 1, 6};

        System.out.println("Sum of XOR totals: " + subsetXORSum(nums1)); // Output: 6
        System.out.println("Sum of XOR totals: " + subsetXORSum(nums2)); // Output: 28
    }
}

