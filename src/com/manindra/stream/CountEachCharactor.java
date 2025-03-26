package com.manindra.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountEachCharactor {

    public static void main(String[] args) {

        String s = "string data to count each character";
        Map<String, Long> charCount = Arrays.stream(s.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));

        charCount.forEach((character, count) -> System.out.println(character + ": " + count));
    }

    /*public static void main(String[] args) {
        String s = "string data to count each character";

        LinkedHashMap<String, Long> wordCount =
                Arrays.stream(s.split(" ")) // Step 1: Convert string into a stream of words
                        .map(String::toLowerCase) // Step 2: Convert each word to lowercase
                        .collect(Collectors.groupingBy(
                                st -> st, // Step 3: Use the word as the key
                                LinkedHashMap::new, // Step 4: Use a LinkedHashMap to maintain order
                                Collectors.counting() // Step 5: Count occurrences of each word
                        ));

        System.out.println(wordCount);
        }
        */
}
