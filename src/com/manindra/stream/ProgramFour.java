package com.manindra.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramFour {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        words.stream().map(s->s.length()).collect(Collectors.toList());
        System.out.println(wordLengths);


        List<String> words2 = Arrays.asList("Hello", "World");
        List<String> uniqueLetters = words2.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueLetters);
    }
}
