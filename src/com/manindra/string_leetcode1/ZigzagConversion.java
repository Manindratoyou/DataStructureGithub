package com.manindra.string_leetcode1;

public class ZigzagConversion { //solution 6

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3)); // "PAHNAPLSIIGYIR"
        System.out.println(convert("PAYPALISHIRING", 4)); // "PINALSIGYAHRPI"
        System.out.println(convert("AB", 1));             // "AB"
    }


    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[curRow].append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) result.append(row);
        return result.toString();
    }


}

