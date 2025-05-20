package com.manindra.leetcodemedium_2;

public class ZeroArrayTransformation { //solution 3355

    public static void main(String[] args) {
        ZeroArrayTransformation obj = new ZeroArrayTransformation();

        System.out.println(obj.isZeroArray(new int[]{1, 0, 1}, new int[][]{{0, 2}})); // true
        System.out.println(obj.isZeroArray(new int[]{4, 3, 2, 1}, new int[][]{{1, 3}, {0, 2}})); // false
        System.out.println(obj.isZeroArray(new int[]{1, 1, 1, 1}, new int[][]{{0, 3}})); // true
        System.out.println(obj.isZeroArray(new int[]{2, 2, 2}, new int[][]{{0, 1}, {1, 2}})); // true
    }


    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];  // Difference array for prefix sum logic

        // Mark increments for each query range
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            diff[l]++;
            if (r + 1 < n) diff[r + 1]--;
        }

        // Build the prefix sum array to get coverage count per index
        int[] coverage = new int[n];
        coverage[0] = diff[0];
        for (int i = 1; i < n; i++) {
            coverage[i] = coverage[i - 1] + diff[i];
        }

        // Final check
        for (int i = 0; i < n; i++) {
            if (nums[i] > coverage[i]) return false;
        }

        return true;
    }
}

