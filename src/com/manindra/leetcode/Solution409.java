package com.manindra.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution409 { //Longest Palindrome

    public static void main(String[] args) {
        // Example Input:
        String s = "abccccdd";

        // Calculate and print the length of the longest palindrome
        int result = longestPalindrome(s);
        System.out.println("Length of the longest palindrome: " + result);
    }

    static int longestPalindrome(String s){

        Map<Character,Integer> frequencyMap=new HashMap<>();

        for (char c : s.toCharArray()){
            frequencyMap.put(c,frequencyMap.getOrDefault(c,0)+1);
        }
        int length =0;
        boolean hasOddFrequency=false;

        //calculate length of longest palindrome
        for (int frequency :frequencyMap.values()){
            length+=frequency/2 *2;
            if (frequency%2==1)
                hasOddFrequency=true;
        }
        // Add one for a single character with odd frequency (if any)
        if (hasOddFrequency) {
            length++;
        }

        return length;
    }

    public static int longestPalindromeSolutionTwo(String s) {
        int[] charCount = new int[128];

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            charCount[c]++;
        }

        int length = 0;

        // Calculate the length of the longest palindrome
        for (int count : charCount) {
            length += count / 2 * 2;
        }

        // Add one for a single character with odd frequency (if any)
        if (length < s.length()) {
            length++;
        }

        return length;
    }
}
