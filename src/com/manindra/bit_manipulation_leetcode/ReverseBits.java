package com.manindra.bit_manipulation_leetcode;

public class ReverseBits { //solution 190

    public static void main(String[] args) {
        int n = 43261596; // binary: 00000010100101000001111010011100
        System.out.println(reverseBits(n)); // 964176192
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;         // shift result left to make room
            result |= (n & 1);    // add the last bit of n
            n >>= 1;              // shift n right to process next bit
        }
        return result;
    }

    public static int reverseBitsOptimized(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }


}

