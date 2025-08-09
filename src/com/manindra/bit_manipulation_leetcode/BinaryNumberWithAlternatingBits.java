package com.manindra.bit_manipulation_leetcode;

public class BinaryNumberWithAlternatingBits { //solution 693

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));  // true
        System.out.println(hasAlternatingBits(7));  // false
        System.out.println(hasAlternatingBits(11)); // false
    }

    // Normal approach
    static boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }

    // Java 8+ approach
    static boolean hasAlternatingBits2(int n) {
        String binary = Integer.toBinaryString(n);
        return java.util.stream.IntStream.range(0, binary.length() - 1)
                .allMatch(i -> binary.charAt(i) != binary.charAt(i + 1));
    }
}

