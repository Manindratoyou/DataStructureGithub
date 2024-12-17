package com.manindra.hackerrank;

public class MarsExploration {

    public static void main(String[] args) {

        String s = "SOSSPSSQSSOR";
        String s1 = "SOSSOT";
        System.out.println(marsExploration(s1));
    }

    public static int marsExploration(String s) {

        int ans = 0;
        for (int i = 0; i < s.length(); i += 3) {
            if (!s.substring(i, i + 3).equals("SOS"))
                ans += findDifferentLetters(s.substring(i, i + 3));
        }
        return ans;
    }

    private static int findDifferentLetters(String substring) {
        int count = 0;
        if (substring.charAt(0) != 'S')
            count++;
        if (substring.charAt(1) != 'O')
            count++;
        if (substring.charAt(2) != 'S')
            count++;

        return count;
    }
}
