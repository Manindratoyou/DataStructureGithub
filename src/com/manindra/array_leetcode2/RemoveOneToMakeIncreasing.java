package com.manindra.array_leetcode2;

public class RemoveOneToMakeIncreasing { //solution 1909

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 10, 5, 7};
        int[] nums2 = {2, 3, 1, 2};
        int[] nums3 = {1, 1, 1};

        System.out.println(canBeIncreasing(nums1)); // true
        System.out.println(canBeIncreasing(nums2)); // false
        System.out.println(canBeIncreasing(nums3)); // false
    }

    public static boolean canBeIncreasing(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                count++;
                if (count > 1)
                    return false;

                if (i > 0 && nums[i - 1] >= nums[i + 1]) {
                    // we cannot remove nums[i], so must remove nums[i + 1]
                    if (i + 2 < nums.length && nums[i] >= nums[i + 2]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

