package com.manindra.leetcodemedium_2;

public class JumpGameII { //solution 45

    public static void main(String[] args) {

        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};
        int[] nums3 = {1, 2, 3};
        int[] nums4 = {1, 2, 1, 1, 1};
        int[] nums5 = {1, 1, 1, 1, 1};

        System.out.println(jump(nums1)); // Expected output: 2
        System.out.println(jump(nums2)); // Expected output: 2
        System.out.println(jump(nums3)); // Expected output: 2
        System.out.println(jump(nums4)); // Expected output: 3
        System.out.println(jump(nums5)); // Expected output: 4
    }

    static int jump(int[] nums) {

        int totalJumps = 0;

        // destination is last index
        int destination = nums.length - 1;

        int coverage = 0, lastJumpIdx = 0;

        // Base case
        if (nums.length == 1) return 0;

        // Greedy strategy: extend coverage as long as possible
        for (int i = 0; i < nums.length; i++) {

            coverage = Math.max(coverage, i + nums[i]);

            if (i == lastJumpIdx) {
                lastJumpIdx = coverage;
                totalJumps++;

                // check if we reached destination already
                if (coverage >= destination) {
                    return totalJumps;
                }
            }
        }

        return totalJumps;
    }

}
