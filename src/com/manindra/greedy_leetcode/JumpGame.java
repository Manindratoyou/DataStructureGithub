package com.manindra.greedy_leetcode;

public class JumpGame {//solution 55

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};  // Expected output: true
        int[] nums2 = {3, 2, 1, 0, 4};  // Expected output: false
        int[] nums3 = {1,1,2,5,2,1,0,0,1,3};

        System.out.println("Can jump (Test case 1): " + canJump(nums1)); // true
        System.out.println("Can jump (Test case 2): " + canJump(nums2)); // false
        System.out.println("Can jump (Test case 3): " + canJump(nums3));
    }

    //Approach 1: Dynamic Programming (Backward check)
    static boolean canJump(int[] nums) {

        // Initially the final position is the last index
        int finalPosition = nums.length - 1;

        // Start with the second last index
        for (int idx = nums.length - 2; idx >= 0; idx--) {

            // If you can reach the final position from this index
            // update the final position flag
            if (idx + nums[idx] >= finalPosition) {
                finalPosition = idx;
            }
        }

        // If we reach the first index, then we can
        // make the jump possible
        return finalPosition == 0;
    }

    //Approach 2: Greedy (Efficient)
    public static boolean canJumpGreedy(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // Can't reach this index
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
