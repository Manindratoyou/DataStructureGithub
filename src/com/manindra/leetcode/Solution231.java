package com.manindra.leetcode;

public class Solution231 { //power of two

    public static void main(String args[]) {

        // Function call
        if (isPowerOfTwo(31))
            System.out.println("Yes");
        else
            System.out.println("No");

        if (isPowerOfTwo(64))
            System.out.println("Yes");
        else
            System.out.println("No");
        System.out.println("==========");

        System.out.println(isPowerOfTwoSolutionTwo(1));
        System.out.println(isPowerOfTwoSolutionTwo(16));
        System.out.println(isPowerOfTwoSolutionTwo(218));
    }

    static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;

        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }

    static boolean isPowerOfTwoSolutionTwo(int n) {
        if (n <= 0) {
            return false;
        }
        // A power of two in binary has only one '1' bit.
        // Using the bitwise AND operator to check for this condition.
        return (n & (n - 1)) == 0;
    }


}
