package com.manindra.string_leetcode1;

public class ExcelSheetColumnNumber { //solution 171

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));   // 1
        System.out.println(titleToNumber("AB"));  // 28
        System.out.println(titleToNumber("ZY"));  // 701
    }

    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            result = result * 26 + (ch - 'A' + 1);
        }
        return result;
    }
    public static int titleToNumber2(String columnTitle) {
        return columnTitle.chars()
                .reduce(0, (result, ch) -> result * 26 + (ch - 'A' + 1));
    }
}

