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

        LinkedHashMap<String, Long> wordCount = Arrays.stream(s.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        st -> st, LinkedHashMap::new, Collectors.counting()
                ));

        System.out.println(wordCount);
    }*/
}
