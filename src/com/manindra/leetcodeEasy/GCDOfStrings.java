package com.manindra.leetcodeEasy;

public class GCDOfStrings { //solution 1071

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));  // Output: "ABC"
        System.out.println(gcdOfStrings("ABABAB", "ABAB")); // Output: "AB"
        System.out.println(gcdOfStrings("LEET", "CODE"));   // Output: ""
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";

        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}

