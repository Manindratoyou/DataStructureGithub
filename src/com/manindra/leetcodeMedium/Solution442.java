package com.manindra.leetcodeMedium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution442 { //Find All Duplicates in an Array

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};// Output: [2,3]
        //List<Integer> result1=findDuplicatesConstantSpace(nums);
        //System.out.println(result1);
        List<Integer> result2 = findDuplicatesLinearSpace(nums);
        System.out.println(result2);

    }

    static List<Integer> findDuplicatesConstantSpace(int[] nums) { //without any extra space 0(1)

        List<Integer> resultSet = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Get the index, the element corresponds to
            int index = Math.abs(nums[i]) - 1;

            // If the number is already negative, it means we are
            // encountering it twice
            if (nums[index] < 0)
                resultSet.add(index + 1);

            // Flip the number at the index to negative
            nums[index] = nums[index] * -1;
        }

        return resultSet;
    }

    static List<Integer> findDuplicatesLinearSpace(int[] nums) {

        List<Integer> resultSet = new ArrayList<>();

        // Set to store unique numbers
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums) {

            // If already present, then it is a duplicate
            if (uniqueSet.contains(num))
                resultSet.add(num);

            // Add the number to the set
            uniqueSet.add(num);
        }

        return resultSet;
    }

}
