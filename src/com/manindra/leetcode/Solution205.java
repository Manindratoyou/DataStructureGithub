package com.manindra.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution205 { //Isomorphic String

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));     // true
        System.out.println(isIsomorphic("foo", "bar"));     // false
        System.out.println(isIsomorphic("paper", "title")); // true
        System.out.println(isIsomorphic("ab", "aa"));       // false
    }

    static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> mappedValues = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if (!map.containsKey(original)) {
                if (mappedValues.contains(replacement)) {
                    return false;
                }
                map.put(original, replacement);
                mappedValues.add(replacement);
            } else {
                if (map.get(original) != replacement) {
                    return false;
                }
            }
        }
        return true;
    }


    static boolean isIsomorphicSolutionTwo(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sCharMap = new int[256];//mapping array for characters in string 's'
        int[] tCharMap = new int[256];//mapping array for characters in string 't'

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            //check the character mappings are different in 's' and 't'
            if (sCharMap[sChar] != tCharMap[tChar]) return false;

            //update the character mapping in 's' and 't'
            if (sCharMap[sChar] == 0)
                sCharMap[sChar] = i + 1;//increment by 1 to avoid index 0 conflict.
            if (tCharMap[tChar] == 0)
                tCharMap[tChar] = i + 1;//increment by 1 to avoid index 0 conflict

        }

        return true;
    }

}