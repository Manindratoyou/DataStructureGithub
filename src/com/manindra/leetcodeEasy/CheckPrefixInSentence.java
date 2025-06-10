package com.manindra.leetcodeEasy;

import java.util.stream.IntStream;

public class CheckPrefixInSentence { //solution 1455

    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("i love eating burger", "burg"));  // Output: 4
        System.out.println(isPrefixOfWord("this problem is easy", "pro"));   // Output: 2
        System.out.println(isPrefixOfWord("hello world", "world"));          // Output: 2
        System.out.println(isPrefixOfWord("i am learning", "learned"));      // Output: -1
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1; // 1-based index
            }
        }

        return -1;
    }

    public static int isPrefixOfWord2(String sentence, String searchWord) {
        String[] words = sentence.split(" ");

        return IntStream.range(0, words.length)
                .filter(i -> words[i].startsWith(searchWord))
                .map(i -> i + 1)
                .findFirst()
                .orElse(-1);
    }

    public static int isPrefixOfWord3(String sentence, String searchWord) {
        int wordIndex = 1;
        int i = 0;
        int n = sentence.length();

        while (i < n) {
            // Start of a word
            int j = 0;
            // Compare character by character
            while (i < n && j < searchWord.length() && sentence.charAt(i) == searchWord.charAt(j)) {
                i++;
                j++;
            }

            // If j reached end of searchWord, it was a prefix
            if (j == searchWord.length()) {
                return wordIndex;
            }

            // Skip rest of current word
            while (i < n && sentence.charAt(i) != ' ') {
                i++;
            }

            // Skip the space
            i++;
            wordIndex++;
        }

        return -1;
    }

}

