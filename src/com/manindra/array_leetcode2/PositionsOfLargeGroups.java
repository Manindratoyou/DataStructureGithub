package com.manindra.array_leetcode2;

import java.util.*;
import java.util.stream.IntStream;

public class PositionsOfLargeGroups { //solution 830

    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abbxxxxzzy")); // [[3, 6]]
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd")); // [[3,5],[6,9],[12,14]]
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int n = s.length();
        int start = 0; // start index of current group

        for (int i = 1; i <= n; i++) {
            // If end of string or current char != previous char
            if (i == n || s.charAt(i) != s.charAt(start)) {
                if (i - start >= 3) {
                    result.add(Arrays.asList(start, i - 1));
                }
                start = i; // new group starts
            }
        }
        return result;
    }

    public static List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int[] start = {0};

        IntStream.rangeClosed(0, s.length()) // inclusive to handle last group
                .forEach(i -> {
                    if (i == s.length() || s.charAt(i) != s.charAt(start[0])) {
                        if (i - start[0] >= 3) {
                            result.add(Arrays.asList(start[0], i - 1));
                        }
                        start[0] = i;
                    }
                });

        return result;
    }
}

