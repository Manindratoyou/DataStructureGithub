package com.manindra.string_leetcode1;

import java.util.*;
import java.util.stream.IntStream;

public class OccurrencesAfterBigram { //solution 1078

    public static void main(String[] args) {
        OccurrencesAfterBigram obj = new OccurrencesAfterBigram();
        System.out.println(Arrays.toString(obj.findOcurrences("alice is a good girl she is a good student", "a", "good")));
        // ["girl","student"]

        System.out.println(Arrays.toString(obj.findOcurrences("we will we will rock you", "we", "will")));
        // ["we","rock"]
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> result = new ArrayList<>();

        for (int i = 2; i < words.length; i++) {
            if (words[i - 2].equals(first) && words[i - 1].equals(second)) {
                result.add(words[i]);
            }
        }
        return result.toArray(new String[0]);
    }

    public String[] findOcurrences2(String text, String first, String second) {
        String[] words = text.split(" ");
        return IntStream.range(2, words.length)
                .filter(i -> words[i - 2].equals(first) && words[i - 1].equals(second))
                .mapToObj(i -> words[i])
                .toArray(String[]::new);
    }


}

