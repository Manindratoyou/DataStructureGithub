package com.manindra.leetcodeEasy;

public class IncreasingDecreasingString { //solution 1370

    public static void main(String[] args) {

        String input = "aaaabbbbcccc";

        long startTime = System.nanoTime();
        String result = sortString(input);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Sorted String " + result);
        System.out.println(" Time taken  " + elapsedTime);
    }

    static String sortString(String s) {

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    sb.append((char)('a' + i));
                    count[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    sb.append((char) ('a' + i));
                    count[i]--;
                }
            }
        }
        return sb.toString();
    }
}
