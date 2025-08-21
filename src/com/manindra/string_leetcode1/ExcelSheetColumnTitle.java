package com.manindra.string_leetcode1;

public class ExcelSheetColumnTitle { //solution 168

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));   // A
        System.out.println(convertToTitle(28));  // AB
        System.out.println(convertToTitle(701)); // ZY
        System.out.println(convertToTitle(2147483647)); // FXSHRXW
    }

    public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            n--; // shift for 1-based index
            int remainder = n % 26;
            result.append((char)('A' + remainder));
            n /= 26;
        }

        return result.reverse().toString();
    }

    public static String convertToTitle2(int n) {
        return n == 0 ? "" :
                convertToTitle2((n - 1) / 26) + (char)('A' + (n - 1) % 26);
    }
}

