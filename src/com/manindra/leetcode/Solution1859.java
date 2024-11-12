package com.manindra.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Input: s = "is2 sentence4 This1 a3"
Output: "This is a sentence"
Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
 */
public class Solution1859 { //Sorting the Sentence

    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
        System.out.println(sortSentenceSolutionTwo(s));
        System.out.println(sortSentenceSolutionThree(s));
        System.out.println(sortSentenceSolutionFour(s));
        System.out.println(sortSentenceSolutionFive(s));
    }


    //Time Complexity: O(n log n) where n is the length of the input string.
    //Auxiliary Space: O(n)
    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        Arrays.sort(words, (a, b) -> a.charAt(a.length() - 1) - b.charAt(b.length() - 1));
        return String.join(" ", Arrays.stream(words).map(word -> word.substring(0, word.length() - 1)).
                toArray(String[]::new));
    }

    //Time Complexity: O(n log n) where n is the number of words in the input string.
    //Auxiliary Space: O(n)
    public static String sortSentenceSolutionTwo(String s) {
        String[] words = s.split(" ");
        TreeMap<Integer, String> wordMap = new TreeMap<>();

        for (String word : words) {
            int index = word.charAt(word.length() - 1) - '0';
            wordMap.put(index, word.substring(0, word.length() - 1));
        }

        return String.join(" ", wordMap.values());
    }

    public static String sortSentenceSolutionThree(String s) {
        String[] words = s.split(" ");
        String[] sortedWords = new String[words.length];

        for (String word : words) {
            int index = word.charAt(word.length() - 1) - '0';
            sortedWords[index - 1] = word.substring(0, word.length() - 1);
        }

        return String.join(" ", sortedWords);
    }

    public static String sortSentenceSolutionFour(String s) {

        // Map to store words in correct order
        Map<Integer, String> indexWordMap = new HashMap<>();

        // Split each word based on space
        for (String word : s.split(" ")) {
            int lastIndex = word.length() - 1;

            // get the word and index separately
            int index = word.charAt(lastIndex) - '0';
            String actualWord = word.substring(0, lastIndex);

            indexWordMap.put(index, actualWord);
        }

        // Build the actual string
        StringBuilder actualString = new StringBuilder();
        for (Map.Entry<Integer, String> indexWord : indexWordMap.entrySet()) {
            actualString.append(indexWord.getValue());
            actualString.append(" ");
        }

        return actualString.toString().trim();
    }

    static String sortSentenceSolutionFive(String s) {
        // Split the sentence into words
        String[] words = s.split(" ");

        // Create an array to hold the sorted words
        String[] sortedSentence = new String[words.length];

        // Loop through each word
        for (String word : words) {
            // Find the position by getting the last character and convert to integer
            int position = Character.getNumericValue(word.charAt(word.length() - 1)) - 1;

            // Place the word (excluding the position digit) in the correct position
            sortedSentence[position] = word.substring(0, word.length() - 1);
        }

        // Join the sorted words into a sentence
        return String.join(" ", sortedSentence);
    }

}
