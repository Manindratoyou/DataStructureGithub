package com.manindra.bit_manipulation_leetcode;

public class NumberComplement { //solution 476

    public static void main(String[] args) {
        System.out.println(findComplement(5));  // 2
        System.out.println(findComplement(1));  // 0
        System.out.println(findComplement(10)); // 5
    }

    public static int findComplement(int num) {
        if (num == 0) return 1;

        int mask = 0;
        int n = num;

        while (n != 0) {
            mask = (mask << 1) | 1; // build mask with same length as num
            n >>= 1;
        }

        return num ^ mask;
    }

    public static int findComplementString(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();

        for (char c : binary.toCharArray()) {
            sb.append(c == '0' ? '1' : '0');
        }

        return Integer.parseInt(sb.toString(), 2);
    }


}

