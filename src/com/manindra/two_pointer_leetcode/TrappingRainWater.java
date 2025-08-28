package com.manindra.two_pointer_leetcode;

public class TrappingRainWater { //solution 42

    // Testing
    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println("DP Approach: " + obj.trapDP(height)); // Output: 6
        System.out.println("Two Pointer Approach: " + obj.trapTwoPointer(height)); // Output: 6
    }

    // Approach 1: DP with leftMax & rightMax
    public int trapDP(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }

    // Approach 2: Two Pointer
    public int trapTwoPointer(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }


}

