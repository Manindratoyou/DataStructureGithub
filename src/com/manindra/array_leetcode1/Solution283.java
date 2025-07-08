package com.manindra.array_leetcode1;

public class Solution283 { //Move Zeroes

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

        // Start with the first position
        int insertPosition = 0;

        for (int i = 0; i < nums.length; i++) {
            // FIll all non-zero numbers
            if (nums[i] != 0) {
                nums[insertPosition] = nums[i];
                insertPosition++;
            }
        }

        while (insertPosition < nums.length) {
            nums[insertPosition++] = 0;
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
