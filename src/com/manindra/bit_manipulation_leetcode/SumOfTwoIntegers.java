package com.manindra.bit_manipulation_leetcode;

public class SumOfTwoIntegers { //solution 371

    public static void main(String[] args) {
        System.out.println(getSum(1, 2));   // 3
        System.out.println(getSum(-1, 1));  // 0
        System.out.println(getSum(-2, -3)); // -5
    }

    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1; // carry
            a = a ^ b;                // sum without carry
            b = carry;                // update b to carry
        }
        return a;
    }
}

