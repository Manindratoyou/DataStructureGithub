package com.manindra.leetcode;

public class Solution283 {

    public static void main(String[] args) {
        Solution283 solution = new Solution283();

        // Sample input
        int[] nums1 = {0, 1, 0, 3, 12};
        int [] nums = {0, 2, 0, 3, 0, 4};

        // Print the original array
        System.out.print("Original Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Call the moveZeroes method to move zeros to the end
        //solution.moveZeroes(nums);
        solution.moveZeroesSolTwo(nums);

        // Print the modified array
        System.out.print("Modified Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0; // Index to keep track of the next position for non-zero elements

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // If the current element is non-zero, move it to the nonZeroIndex position
                nums[nonZeroIndex] = nums[i];
                // If nonZeroIndex is less than the current index, set the current index to zero
                if (nonZeroIndex != i) {
                    nums[i] = 0;
                }
                nonZeroIndex++; // Increment the nonZeroIndex
            }
        }
    }

    public void moveZeroesSolTwo(int[] nums) {
        int nonZeroIndex = 0; // Pointer to place non-zero elements

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap the non-zero element with the element at nonZeroIndex
                int temp = nums[nonZeroIndex];
                nums[nonZeroIndex] = nums[i];
                nums[i] = temp;
                nonZeroIndex++; // Increment the nonZeroIndex
            }
        }
    }
}
