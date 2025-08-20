package com.manindra.array_leetcode2;

import java.util.Arrays;

public class AssignCookies { //solution 455

    public static void main(String[] args) {
        int[] g1 = {1,2,3};
        int[] s1 = {1,1};
        System.out.println(findContentChildren(g1, s1)); // Output: 1

        int[] g2 = {1,2};
        int[] s2 = {1,2,3};
        System.out.println(findContentChildren(g2, s2)); // Output: 2
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0; // i for children, j for cookies
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) { // assign cookie
                i++;
            }
            j++; // move to next cookie
        }
        return i; // number of satisfied children
    }

    public static int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j++] >= g[i]) {
                i++;
            }
        }
        return i;
    }
}

