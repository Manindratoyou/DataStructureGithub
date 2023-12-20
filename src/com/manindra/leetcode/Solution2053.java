package com.manindra.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/*
Input: arr = ["d","b","c","b","c","a"], k = 2
Output: "a"
Explanation:
The only distinct strings in arr are "d" and "a".
"d" appears 1st, so it is the 1st distinct string.
"a" appears 2nd, so it is the 2nd distinct string.
Since k == 2, "a" is returned.
 */
public class Solution2053 { //Kth Distinct String in an Array

    public static void main(String[] args) {
        String[] arr = {"d", "b", "c", "b", "c", "a"};
        int k = 2;

        String kthDistinctString = kthDistinct(arr, k);
        System.out.println(kthDistinctString); // a
    }

    public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> distinctStrings = new LinkedHashMap<>();
        for (String string : arr) {
            distinctStrings.put(string, distinctStrings.getOrDefault(string, 0) + 1);
        }

        int distinctStringCount = 0;
        for (String string : distinctStrings.keySet()) {
            if (distinctStrings.get(string) == 1) {
                distinctStringCount++;
            }

            if (distinctStringCount == k) {
                return string;
            }
        }

        return "";
    }


}
