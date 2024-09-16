package com.manindra.interview_2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class NonRepeatingCharString {

    public static void main(String[] args) {

        String input1="aabbcc";
        String input2="leetcode";
        String input3="loveleetcode";
        //System.out.println(firstUniqueCharSolOne(input3));
        //System.out.println(firstUniqueCharSolTwo(input3));
        System.out.println(firstUniqueCharSolThree(input3));
    }

    static int firstUniqueCharSolOne(String s){

        //create an array to store the frequency of each character
        int [] charArray=new int[26];

        //count the frequency of each character in the string
        for (char c: s.toCharArray()){
            charArray[c-'a']++;
        }
        //iterate though the string to find the first unique character
        for (int i=0;i<s.length();i++){
            if (charArray[s.charAt(i)-'a']==1)
                return i;
        }

        //if no unique character found ,return -1;
        return -1;
    }

    static int firstUniqueCharSolTwo(String s){

        //create a linked hash mp to maintain the order of character
        Map<Character,Integer> map=new LinkedHashMap<>();

        //count the frequency of each character in the string
        //and stored in the linked hash map
        for (char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        //iterate through the linked hash map to find the first unique character
        for (Map.Entry<Character,Integer> m: map.entrySet()){
            if (m.getValue()==1)
                return s.indexOf(m.getKey());
        }
        //if no unique char found ,return -1;
        return -1;
    }

    static int firstUniqueCharSolThree(String s){

        Optional<Character> firstUnique = s.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> s.indexOf(c) == s.lastIndexOf(c))
                .findFirst();

        return firstUnique.map(s::indexOf).orElse(-1);
    }



}
