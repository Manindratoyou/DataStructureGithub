package com.manindra.hackerrank_2;

public class HackerRankInString {

    public static void main(String[] args) {
        System.out.println(hackerrankInString("hereiamstackerrank"));
    }
    public static String hackerrankInString(String s) {
        String hackerrank = "hackerrank";
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == hackerrank.charAt(index)) {
                index++;
            }
            if (index == hackerrank.length()) {
                return "YES";
            }
        }
        return "NO";

    }

}
