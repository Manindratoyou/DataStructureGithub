package com.manindra.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution242 { //valid Anagram

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); //output : true
        System.out.println(isAnagram("rat", "car"));         //output : false
        System.out.println(isAnagram("listen", "silent"));   //output : true
        System.out.println("-----------------------------------");

        System.out.println(isAnagramSolutionTwo("anagram", "nagaram")); //output : true
        System.out.println(isAnagramSolutionTwo("rat", "car"));         //output : false
        System.out.println(isAnagramSolutionTwo("listen", "silent"));   //output : true
        System.out.println("-----------------------------------");

        System.out.println(isAnagramSolutionThree("anagram", "nagaram")); //output : true
        System.out.println(isAnagramSolutionThree("rat", "car"));         //output : false
        System.out.println(isAnagramSolutionThree("listen", "silent"));   //output : true
        System.out.println("-----------------------------------");

        System.out.println(isAnagramSolutionFour("anagram", "nagaram")); //output : true
        System.out.println(isAnagramSolutionFour("rat", "car"));         //output : false
        System.out.println(isAnagramSolutionFour("listen", "silent"));   //output : true
        System.out.println("-----------------------------------");
    }

    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }

    static boolean isAnagramSolutionTwo(String s, String t) {
        if (s.length() != t.length()) return false;

        //create a frequency map for character in string s
        Map<Character, Integer> frequencyMap = new HashMap<>();

        //increment frequency for character in string s
        for (char c : s.toCharArray())
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);

        //decrement frequency for characters in string t
        for (char c : t.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) - 1);

            //if the frequency become negative string are not anagram
            if (frequencyMap.get(c) < 0) return false;
        }
        //if all frequency are zero string are anagram
        return true;
    }

    static boolean isAnagramSolutionThree(String s, String t) {
        if (s.length() != t.length()) return false;

        //create an array to represent the frequency of each character
        int [] frequency=new int[26];

        //increment frequency for character in string s
        for (char c: s.toCharArray())
            frequency[c-'a']++;

        //decrement frequency for character in string t
        for (char c: t.toCharArray()) {
            frequency[c - 'a']--;

            //if the frequency become negative strings are not anagram
            if (frequency[c-'a']<0) return false;
        }
        //if all frequency are zero strings are anagram
        return true;
    }

    static boolean isAnagramSolutionFour(String s, String t) {
        if (s.length() != t.length()) return false;

        //create array to represent the frequency of each character
        int [] countS=new int[26];
        int [] countT=new int[26];

        //increment frequency for character in string s
        for (char c : s.toCharArray())
            countS[c-'a']++;

        //increment frequency for character in string s
        for (char c : t.toCharArray())
            countT[c-'a']++;

        //compare the two arrays
        for (int i=0;i<26;i++){
            if (countS[i] !=countT[i])
                return false;
        }

        return true;
    }
}
