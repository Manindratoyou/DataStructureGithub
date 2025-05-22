package com.manindra.leetcodemedium_2;

public class EqualSubstring { //solution 1208


    public static void main(String[] args) {

        String  s = "abcd", t = "bcdf"; int  maxCost = 3;
        String  s2 = "abcd", t2 = "cdef"; int  maxCost2 = 3;
        System.out.println(equalSubstring(s,t,maxCost));
        System.out.println(equalSubstring(s2,t2,maxCost2));
    }

    static int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int ans = -1, window = 0, left = 0;
        for (int right = 0; right < n; right++) {
            window += Math.abs(s.charAt(right) - t.charAt(right));
            while (window > maxCost) {
                window -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
