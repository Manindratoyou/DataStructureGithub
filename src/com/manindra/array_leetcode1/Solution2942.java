package com.manindra.array_leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution2942 { //words with given character

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "orange", "kiwi", "grape"};
        char targetChar = 'a';

        List<String> StringResult = findWordsWithCharacterSolutionOne(words, targetChar);
        List<Integer> IntResult = findIndicesOfCharacter(words, targetChar);

        System.out.println("Words containing '" + targetChar + "': " + StringResult);
        System.out.println("Words containing '" + targetChar + "': " + IntResult);

    }


    //Time Complexity: O(m * n) Auxiliary Space: O(k)
    public static List<String> findWordsWithCharacterSolutionOne(String[] words, char targetChar) {
        return Arrays.stream(words)
                .filter(word -> word.indexOf(targetChar) != -1)
                .collect(Collectors.toList());

    }
    public static List<Integer> findIndicesOfCharacter(String[] words, char targetChar) {
        List<Integer> result = new ArrayList<>();

        IntStream.range(0, words.length)
                .filter(i -> words[i].indexOf(targetChar) != -1)
                .forEach(result::add);

        return result;
    }

    public static List<String> findWordsWithCharacterSolutionTwo(String[] words, char targetChar) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (containsCharacter(word, targetChar)) {
                result.add(word);
            }
        }

        return result;
    }

    private static boolean containsCharacter(String word, char targetChar) {
        for (char c : word.toCharArray()) {
            if (c == targetChar) {
                return true;
            }
        }
        return false;
    }

    public static List<String> findWordsWithCharacter1(String[] words, char targetChar) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (containsCharacter(words[i], targetChar)) {
                result.add(words[i]);
            }
        }

        return result;
    }

    private static boolean containsCharacter1(String word, char targetChar) {
        return word.indexOf(targetChar) != -1;
    }

}
