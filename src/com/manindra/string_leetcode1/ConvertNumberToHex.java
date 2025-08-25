package com.manindra.string_leetcode1;

public class ConvertNumberToHex { //solution 405

    public static void main(String[] args) {
        System.out.println(toHex(26));    // "1a"
        System.out.println(toHex(-1));    // "ffffffff"
        System.out.println(toHex(0));     // "0"
        System.out.println(toHex(16));    // "10"
    }

    public static String toHex(int num) {
        if (num == 0) return "0";

        char[] map = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            sb.append(map[num & 0xf]); // last 4 bits
            num >>>= 4; // unsigned right shift
        }

        return sb.reverse().toString();
    }

    public static String toHex2(int num) {
        return Integer.toHexString(num);
    }
}

