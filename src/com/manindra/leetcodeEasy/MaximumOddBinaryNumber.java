package com.manindra.leetcodeEasy;

public class MaximumOddBinaryNumber { //solution 2864

    public static void main(String[] args) {
        // Test Cases
        System.out.println(maximumOddBinaryNumber("0101")); // Output: "1100"
        System.out.println(maximumOddBinaryNumber("1001")); // Output: "1100"
        System.out.println(maximumOddBinaryNumber("1111")); // Output: "1111"
        System.out.println(maximumOddBinaryNumber("0110")); // Output: "1010"
    }

    static String maximumOddBinaryNumber(String s) {

        // Count total 0's and 1's in string
        int countZero = 0;
        int countOne = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                countZero++;
            else
                countOne++;
        }

        // Build the answer
        StringBuilder ans = new StringBuilder();

        // Add the first 1
        ans.append("1");
        countOne--;

        // Add all the 0's
        ans.append("0".repeat(countZero));

        // Add the remaining 1's
        ans.append("1".repeat(countOne));

        // Reverse and return the answer
        return ans.reverse().toString();
    }

    public static String maximumOddBinaryNumber2(String s) {
        // Count total 0's and 1's in string
        int countZero = 0;
        int countOne = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                countZero++;
            else
                countOne++;
        }

        // Build the answer
        StringBuilder ans = new StringBuilder();

        // Step 1: Add (countOne - 1) '1's at the beginning
        ans.append("1".repeat(countOne - 1));

        // Step 2: Add all '0's
        ans.append("0".repeat(countZero));

        // Step 3: Add exactly one '1' at the end to make it odd
        ans.append("1");

        return ans.toString();
    }

}
