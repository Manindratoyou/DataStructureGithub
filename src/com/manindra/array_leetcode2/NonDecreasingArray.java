package com.manindra.array_leetcode2;

public class NonDecreasingArray { //solution 655

    public static void main(String[] args) {
        NonDecreasingArray solution = new NonDecreasingArray();
        int[] nums1 = {4, 2, 3};
        int[] nums2 = {4, 2, 1};

        System.out.println(solution.checkPossibility(nums1)); // true
        System.out.println(solution.checkPossibility(nums2)); // false
    }

    public boolean checkPossibility(int[] nums) {
        int count = 0; // Count modifications

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (count > 1) return false;

                // Modify either nums[i - 1] or nums[i]
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i]; // Lower previous
                } else {
                    nums[i] = nums[i - 1]; // Raise current
                }
            }
        }
        return true;
    }

}

