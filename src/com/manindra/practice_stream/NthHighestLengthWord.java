package com.manindra.practice_stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class NthHighestLengthWord {

    public static void main(String[] args) {
        String s = "I am learning Streams API in Java";
        int n=1;
        Optional<String> secondLongestWord = Arrays.stream(s.split("\\s+"))
                .distinct() // Keep only unique words
                .sorted(Comparator.comparingInt(String::length).reversed()) // Sort by length descending
                .skip(n) // Skip the longest word
                .findFirst();

        if (secondLongestWord.isPresent()) {
            System.out.println("The second longest word is: " + secondLongestWord.get());
        } else {
            System.out.println("There is no second longest word (less than two unique words).");
        }

        System.out.println();
        String s1 = Arrays.stream(s.split(" ")).sorted(Comparator.comparing(String::length).reversed())
                .skip(1).findFirst().get();

        System.out.println(s1);
    }
}
