package com.manindra.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class ValidString {

    static String isValid(String s) {
        // Count the frequency of each character in the string
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Count the frequency of frequencies
        Map<Integer, Integer> frequencyOfFrequencies = new HashMap<>();
        for (int freq : frequencyMap.values()) {
            frequencyOfFrequencies.put(freq, frequencyOfFrequencies.getOrDefault(freq, 0) + 1);
        }

        if (frequencyOfFrequencies.size() == 1) {
            // If all characters appear the same number of times
            return "YES";
        } else if (frequencyOfFrequencies.size() == 2) {
            // If there are two different frequencies
            int freq1 = 0, freq2 = 0;
            for (int freq : frequencyOfFrequencies.keySet()) {
                if (freq1 == 0) {
                    freq1 = freq;
                } else {
                    freq2 = freq;
                }
            }
            if ((freq1 == 1 && frequencyOfFrequencies.get(freq1) == 1) || // Remove one character
                    (Math.abs(freq1 - freq2) == 1 && (frequencyOfFrequencies.get(freq1) == 1 || frequencyOfFrequencies.get(freq2) == 1))) {
                // Remove one character and the rest have the same frequency
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        String input1 = "aabbcd";
        String input2 = "aabbccddeefghi";
        String input3 = "abcdefghhgfedecba";

        System.out.println(isValid(input1));  // Output: NO
        System.out.println(isValid(input2));  // Output: NO
        System.out.println(isValid(input3));  // Output: YES
    }
}

