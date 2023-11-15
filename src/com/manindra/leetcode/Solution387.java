package com.manindra.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution387 { //FirstUniqueCharacter

    public static void main(String[] args) {
        String input1 = "z";
        String input2 = "aabbcc";
        String input3 = "";
        String input4 = "loveleetcode";
        String input5 = "leetcode";
        System.out.println(firstUniqueChar(input1));
        System.out.println(firstUniqueChar(input2));
        System.out.println(firstUniqueChar(input3));
        System.out.println(firstUniqueChar(input4));
        System.out.println("======================");
        System.out.println(firstUniqueCharSolTwo(input2));
        System.out.println(firstUniqueCharSolTwo(input3));
        System.out.println(firstUniqueCharSolTwo(input4));
        System.out.println(firstUniqueCharSolTwo(input5));

    }

    static int firstUniqueChar(String s){

        //create the array to store the frequency of each character
        int [] charArray=new int[26];

        // Count the frequency of each character in the string
        for (char c : s.toCharArray())
            charArray[c-'a']++;

        // Iterate through the string to find the first unique character
        for (int i=0;i<s.length();i++){
            if (charArray[s.charAt(i)-'a']==1)
                return i;
        }

        // If no unique character is found, return -1
        return -1;

    }

    static int firstUniqueCharSolTwo(String s){

        //create a linked hashmap to maintain the order of character
        Map<Character,Integer> map=new LinkedHashMap<>();

        // Count the frequency of each character in the string and store in the LinkedHashMap
        for (char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        // Iterate through the LinkedHashMap to find the first unique character
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if (entry.getValue()==1)
                return s.indexOf(entry.getKey());
        }

        // If no unique character is found, return -1
        return -1;

    }
}
