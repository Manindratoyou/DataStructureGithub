package com.manindra.array_leetcode2;

public class NumberOfLinesToWriteString { //solution 806

    public static void main(String[] args) {
        int[] widths = new int[26];
        for (int i = 0; i < 26; i++) widths[i] = 10;
        String s = "abcdefghijklmnopqrstuvwxyz";

        int[] result = numberOfLines(widths, s);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // [3, 60]
    }

    public static int[] numberOfLines(int[] widths, String s) {
        int lines = 1; // at least one line
        int currentWidth = 0;

        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            if (currentWidth + width > 100) {
                lines++;
                currentWidth = width;
            } else {
                currentWidth += width;
            }
        }
        return new int[]{lines, currentWidth};
    }

    public static int[] numberOfLines2(int[] widths, String s) {
        int lines = 1;
        int currentWidth = 0;

        for (int width : s.chars().map(ch -> widths[ch - 'a']).toArray()) {
            if (currentWidth + width > 100) {
                lines++;
                currentWidth = width;
            } else {
                currentWidth += width;
            }
        }
        return new int[]{lines, currentWidth};
    }

}

