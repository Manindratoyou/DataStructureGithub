package com.manindra.hackerrank;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoStrings {

    public static void main(String[] args) {

        String s1="and",s2="art";
        System.out.println(twoStrings(s1,s2));
        System.out.println(twoStrings2(s1,s2));
        System.out.println(twoStrings3(s1,s2));
        System.out.println(twoStrings4(s1,s2));
        System.out.println(twoStrings5(s1,s2));

    }

    static String twoStrings(String s1,String s2){

        Set<Character> s1Set=new HashSet<>();
        Set<Character> s2Set=new HashSet<>();

        //creating the set of string1
        for (char c: s1.toCharArray()){
            s1Set.add(c);
        }

        //creating the set of string2
        for (char c: s2.toCharArray()){
            s2Set.add(c);
        }

        //store the set interaction in s1Set
        s1Set.retainAll(s2Set);

        if (!s1Set.isEmpty()){
            return "YES";
        }

        return "NO";
    }

    static String twoStrings2(String s1, String s2) {
        Set<Character> set = new HashSet<>();

        // Add characters of s1 to the set
        for (char c : s1.toCharArray()) {
            set.add(c);
        }

        // Check if any character of s2 exists in the set
        for (char c : s2.toCharArray()) {
            if (set.contains(c)) {
                return "YES";
            }
        }
        return "NO";
    }

    static String twoStrings3(String s1,String s2){
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();

        //create a frequency array of size 26
        char[] freq=new char[26];

        //increase the frequency of each character for string s2
        for (int i=0;i<s2.length();i++){
            freq[s2.charAt(i)-'a']++;
        }

        //check each character in string s1 for frequency
        //if the frequency is greater than 0 ,it means we found a sub string ,simple return YES
        for (int i=0;i<s1.length();i++){
            if (freq[s1.charAt(i)-'a']>0){
                return "YES";
            }
        }
        return "NO";
    }

    static String twoStrings4(String s1, String s2) {
        Set<Character> set1 = s1.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        return s2.chars().mapToObj(c -> (char) c).anyMatch(set1::contains) ? "YES" : "NO";
    }

    static String twoStrings5(String s1, String s2) {
        int mask1 = 0, mask2 = 0;

        for (char c : s1.toCharArray()) {
            mask1 |= (1 << (c - 'a'));  // Set bit for character
        }

        for (char c : s2.toCharArray()) {
            mask2 |= (1 << (c - 'a'));  // Set bit for character
        }

        return (mask1 & mask2) != 0 ? "YES" : "NO";
    }
}
