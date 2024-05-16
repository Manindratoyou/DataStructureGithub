package com.manindra.leetcodeEasy;

import java.util.Arrays;

public class LongestCommonPrefix { //solution 14

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    static String longestCommonPrefix(String[] strs) {

        StringBuilder result = new StringBuilder();

        //sort the array
        Arrays.sort(strs);

        //get the first and the last string
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        //start comparing
        for (int i = 0; i < first.length; i++) {
            if (first[i] != last[i])
                break;
            result.append(first[i]);
        }

        return result.toString();
    }
}
