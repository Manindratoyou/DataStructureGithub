package com.manindra.practice_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterWordsWithVowels {

    public static void main(String[] args) {

        String input= "I am learning Streams API in Java Java";
        Arrays.stream(input.split(" ")).
                filter(x->x.replaceAll("[^aeiouAEIOU]","").length()==2).
                forEach(System.out::println);
    }

    public static void main2(String[] args) {
        String s = "I am learning Streams API in Java Java";
        List<String> wordsWithVowels = filterWordsWithVowels(s);
        System.out.println("Original string: " + s);
        System.out.println("Words containing at least one vowel: " + wordsWithVowels);
    }

    public static List<String> filterWordsWithVowels(String input) {
        String[] words = input.split("\\s+");
        return Arrays.stream(words)
                .filter(word -> word.toLowerCase().chars().anyMatch(ch -> "aeiou".contains(String.valueOf((char) ch))))
                .distinct() // Optional: to remove duplicate words after filtering
                .collect(Collectors.toList());
    }
}
