package com.manindra.array_leetcode1;

public class RemoveDuplicatesII { //solution 80

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int k = removeDuplicates(nums);
        System.out.println("k = " + k);
        System.out.print("Updated array = ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        // Output: k = 7, Updated array = 0 0 1 1 2 3 3
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int i = 2; // start from the 3rd element
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}

