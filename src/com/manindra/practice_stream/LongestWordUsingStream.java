package com.manindra.practice_stream;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWordUsingStream {

    public static void main(String[] args) {
        String input = "I am learning Streams API in Java";

        String longestWord = Arrays.stream(input.split(" "))
                .max((o1, o2) -> o1.compareTo(o2))
                .orElse("");

        System.out.println("Longest word: " + longestWord);
        System.out.println();

        String s = Arrays.stream(input.split(" ")).
                max(Comparator.comparing(String::length)).get();
        System.out.println(s);
    }
}
