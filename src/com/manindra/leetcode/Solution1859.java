package com.manindra.leetcode;

import java.util.Arrays;
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
    }


    //Time Complexity: O(n log n) where n is the length of the input string.
    //Auxiliary Space: O(n)
    static String sortSentence(String s) {
        String[] words = s.split(" ");
        Arrays.sort(words, (a, b) -> a.charAt(a.length() - 1) - b.charAt(b.length() - 1));
        return String.join(" ", Arrays.stream(words).map(word -> word.substring(0, word.length() - 1)).
                toArray(String[]::new));
    }

    //Time Complexity: O(n log n) where n is the number of words in the input string.
    //Auxiliary Space: O(n)
    static String sortSentenceSolutionTwo(String s) {
        String[] words = s.split(" ");
        TreeMap<Integer, String> wordMap = new TreeMap<>();

        for (String word : words) {
            int index = word.charAt(word.length() - 1) - '0';
            wordMap.put(index, word.substring(0, word.length() - 1));
        }

        return String.join(" ", wordMap.values());
    }

    static String sortSentenceSolutionThree(String s) {
        String[] words = s.split(" ");
        String[] sortedWords = new String[words.length];

        for (String word : words) {
            int index = word.charAt(word.length() - 1) - '0';
            sortedWords[index - 1] = word.substring(0, word.length() - 1);
        }

        return String.join(" ", sortedWords);
    }

}
