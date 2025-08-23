package com.manindra.greedy_leetcode;

public class JumpGameII { //solution 45

    public static void main(String[] args) {

        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};
        int[] nums3 = {1, 2, 3};
        int[] nums4 = {1, 2, 1, 1, 1};
        int[] nums5 = {1, 1, 1, 1, 1};
        int[] nums6 = {2,4,1,2,3,1,1,2};

        System.out.println(jump(nums1)); // Expected output: 2
        System.out.println(jump(nums2)); // Expected output: 2
        System.out.println(jump(nums3)); // Expected output: 2
        System.out.println(jump(nums4)); // Expected output: 3
        System.out.println(jump(nums5)); // Expected output: 4
        System.out.println(jump(nums6));

        System.out.println("================");
        System.out.println(jumpDP(nums1)); // Expected output: 2
        System.out.println(jumpDP(nums2)); // Expected output: 2
        System.out.println(jumpDP(nums3)); // Expected output: 2
        System.out.println(jumpDP(nums4)); // Expected output: 3
        System.out.println(jumpDP(nums5)); // Expected output: 4
        System.out.println(jumpDP(nums6));
    }

    static int jump(int[] nums) { //Greedy

        // destination is last index
        int destination = nums.length - 1;

        int totalJumps = 0;
        int coverage = 0, lastJumpIdx = 0;

        // Base case
        if (nums.length == 1)
            return 0;

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

    public static int jumpDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // Initialize dp with large value
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0; // starting point requires 0 jumps

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }

}
