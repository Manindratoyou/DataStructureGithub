package com.manindra.string_leetcode1;

public class LongestUncommonSubsequenceI { //solution 521


    public static void main(String[] args) {
        System.out.println(findLUSlength("aba", "cdc")); // 3
        System.out.println(findLUSlength("aaa", "aaa")); // -1
        System.out.println(findLUSlength("abcd", "abc")); // 4
    }

    public static int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }
    public static int findLUSlength2(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

}


