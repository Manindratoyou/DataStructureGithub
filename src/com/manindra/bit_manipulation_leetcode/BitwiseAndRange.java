package com.manindra.bit_manipulation_leetcode;

public class BitwiseAndRange { //solution 201

    /*
    Input: left = 5, right = 7
Output: 4

Explanation:
5  => 101
6  => 110
7  => 111
-------------
AND => 100 => 4
     */
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7)); // Output: 4
        System.out.println(rangeBitwiseAnd(0, 0)); // Output: 0
        System.out.println(rangeBitwiseAnd(1, 2147483647)); // Output: 0
    }

    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        // Find the common prefix by shifting both left and right
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        // Shift back to restore the bits
        return left << shift;
    }

    public static int rangeBitwiseAnd2(int left, int right) {
        int result = left;
        for (int i = left + 1; i <= right; i++) {
            result &= i;
            if (result == 0) break; // Early termination
        }
        return result;
    }
}

