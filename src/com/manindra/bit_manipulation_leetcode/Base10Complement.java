package com.manindra.bit_manipulation_leetcode;

public class Base10Complement { //solution 1009

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5));  // 2
        System.out.println(bitwiseComplement(1));  // 0
        System.out.println(bitwiseComplement(0));  // 1
        System.out.println(bitwiseComplement(10)); // 5
    }

    public static int bitwiseComplement(int n) {
        if (n == 0) return 1; // edge case

        int mask = 0;
        int temp = n;

        // Build mask of same length as n
        while (temp != 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }

        return n ^ mask;
    }

    public static int bitwiseComplementString(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();

        for (char c : binary.toCharArray()) {
            sb.append(c == '0' ? '1' : '0');
        }

        return Integer.parseInt(sb.toString(), 2);
    }


}

