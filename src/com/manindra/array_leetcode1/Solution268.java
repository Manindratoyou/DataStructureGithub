package com.manindra.array_leetcode1;

import java.util.HashSet;
import java.util.Set;

public class Solution268 { //missing number

    public static void main(String[] args) {
        // Example Input:
        int[] nums = {3, 0, 1};
        int[] num1 = {9,6,4,2,3,5,7,0,1};

        // Calculate and print the missing number
        //int result = missingNumber(nums);
        int result = missingNumberSolutionTwo(nums);
        System.out.println("Missing number: " + result);
        System.out.println("==================");
        int result2 = missingNumber3(num1);
        System.out.println("Missing number: " + result2);
    }

    public static int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1; // Default return if no missing number is found (not expected in a valid input)
    }

    public static int missingNumberSolutionTwo(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    /*
    Properties of XOR

   Commutative
   A ⊕ B = B ⊕ A

   A ⊕ B ⊕ C ⊕ D = A ⊕ D ⊕ C ⊕ B

  XOR with 0
  A ⊕ 0 = A

  XOR with self
  A ⊕ A = 0
     */
    static int missingNumber3(int[] nums) {

        int allXOR = 0;

        // XOR all numbers in range [0, n]
        for (int i = 0; i <= nums.length; i++) {
            allXOR = allXOR ^ i;
        }

        // XOR all numbers in the given array
        for (int num : nums) {
            allXOR = allXOR ^ num;
        }

        // The missing number
        return allXOR;
    }
}
