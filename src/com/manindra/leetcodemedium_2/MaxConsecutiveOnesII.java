package com.manindra.leetcodemedium_2;

//involves finding the maximum number of consecutive 1s in a binary array
// if you can flip at most one 0
public class MaxConsecutiveOnesII { //solution 487

    public static void main(String[] args) {
        MaxConsecutiveOnesII solution = new MaxConsecutiveOnesII();
        int[] nums = {1, 0, 1, 1, 0, 1};
        System.out.println(solution.findMaxConsecutiveOnes(nums)); // Output: 4
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int left = 0; // Left pointer of the window
        int zeroCount = 0; // Count of zeros in the current window

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If there are more than 1 zero, shrink the window from the left
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Calculate the size of the current window
            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
    }
}

