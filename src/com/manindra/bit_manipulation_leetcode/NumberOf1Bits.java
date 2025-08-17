package com.manindra.bit_manipulation_leetcode;

public class NumberOf1Bits { //solution 191

    public static void main(String[] args) {
        int input = 0b00000000000000000000000000001011; // binary for 11
        System.out.println(hammingWeight(input)); // Output: 3
        //System.out.println(Integer.bitCount(input));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1); // check last bit
            n >>>= 1;         // unsigned right shift
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // drops the lowest set bit
            count++;
        }
        return count;
    }

}

