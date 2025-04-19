package com.manindra.leetcodeEasy;

import java.util.*;
import java.util.stream.Collectors;

public class StringMatchingInArray { //solution 1408

    public static void main(String[] args) {
        String[] words1 = {"mass", "as", "hero", "superhero"};
        String[] words2 = {"leetcode", "et", "code"};
        String[] words3 = {"blue", "green", "bu"};

        System.out.println(stringMatching(words1)); // ["as", "hero"]
        System.out.println(stringMatching(words2)); // ["et", "code"]
        System.out.println(stringMatching(words3)); // []
    }

    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // No need to check more if found
                }
            }
        }

        return result;
    }

    public static List<String> stringMatchingStream(String[] words) {
        return Arrays.stream(words)
                .filter(word -> Arrays.stream(words)
                        .anyMatch(other -> !word.equals(other) && other.contains(word)))
                .collect(Collectors.toList());
    }
}

