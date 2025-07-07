package com.manindra.leetcodeEasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonChars { //leet code 1002

    public static void main(String[] args) {

        String[] input = {"bella", "label", "roller"};
        List<String> result = commonChars(input);
        System.out.println(result);

    }

    public static List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] freq = new int[26];
            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }

            // Update min frequency
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i]-- > 0) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }

    static List<String> commonChars2(String[] words) {

        List<String> result = new ArrayList<>();

        //initialize an array to store the minimum frequency of each other
        int[] minFreq = new int[26];
        for (char c : words[0].toCharArray()) {
            minFreq[c - 'a']++;
        }

        //iterate through the rest of the string
        for (int i = 1; i < words.length; i++) {
            int[] currentFreq = new int[26];

            //count the frequency of each character in the current string
            for (char c : words[i].toCharArray()) {
                currentFreq[c - 'a']++;
            }

            //update the minimum frequency array with current frequency
            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], currentFreq[j]);
            }
        }

        //convert the minimum frequency array to a list of strings
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char) ('a' + i)));
                minFreq[i]--;
            }
        }

        return result;
    }


}
