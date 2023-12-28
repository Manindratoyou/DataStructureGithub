package com.manindra.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
Input: s = "abacbc"
Output: true
Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.
 */
public class Solution1941 { //Check if All Characters Have Equal Number of Occurrences

    public static void main(String[] args) {

        String s = "abacbc";
        //System.out.println(isequal(s));
        System.out.println(isequalSolTwo(s));
    }

    static boolean isequal(String s){
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        Set<Integer> occurrencesSet = new HashSet<>(charCount.values());

        return occurrencesSet.size() == 1;
    }

    private static boolean isequalSolTwo(String s) {
        Map<Character, Long> charCount = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        Set<Long> occurrencesSet = charCount.values().stream().collect(Collectors.toSet());

        return occurrencesSet.size() == 1;
    }
}
