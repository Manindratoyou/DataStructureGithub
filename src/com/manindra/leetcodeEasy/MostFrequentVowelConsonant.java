package com.manindra.leetcodeEasy;

import java.util.*;

public class MostFrequentVowelConsonant { //solution 3541

    public static void main(String[] args) {
        System.out.println(maxFreqSum("apple"));
        System.out.println(maxFreqSum("engineering"));
        System.out.println(maxFreqSum("aabbccddeeiioouu"));
    }

    static int maxFreqSum(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> vowelFreq = new HashMap<>();
        Map<Character, Integer> consonantFreq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                vowelFreq.put(ch, vowelFreq.getOrDefault(ch, 0) + 1);
            } else {
                consonantFreq.put(ch, consonantFreq.getOrDefault(ch, 0) + 1);
            }
        }

        int maxVowelFreq = getMaxFreq(vowelFreq);
        int maxConsonantFreq = getMaxFreq(consonantFreq);

        return maxVowelFreq + maxConsonantFreq;
    }

    static int getMaxFreq(Map<Character, Integer> freqMap) {
        int maxFreq = 0;
        char chosenChar = 'z' + 1;

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            if (freq > maxFreq || (freq == maxFreq && ch < chosenChar)) {
                maxFreq = freq;
                chosenChar = ch;
            }
        }

        return maxFreq;
    }

    public int maxFreqSum2(String s) {
        int[] count = new int[26];// Array to store counts for 'a' through 'z'
        int maxV = 0;
        int maxC = 0;

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++; //holds int values where c holds all lowercase char
            if (isVowel(ch))
                maxV = Math.max(maxV, count[ch - 'a']);

            else
                maxC = Math.max(maxC, count[ch - 'a']);

        }
        return (maxC + maxV);
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        else
            return false;
    }


}

