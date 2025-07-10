package com.manindra.bitmagic;

public class DecimalBinaryConversion {

    public static void main(String[] args) {
        System.out.println(decimalToBinary(17));
        System.out.println(binaryToDecimal("10001"));
    }

    static String decimalToBinary(int n) {
        if (n == 0)
            return "0";
        String result = "";
        while (n > 0) {
            int rem = n % 2;
            n = n / 2;
            result += rem;
        }
        return result;
    }

    static String binaryToDecimal(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 2 + (s.charAt(i) - '0');
        }
        return Integer.valueOf(result).toString();
    }
}
