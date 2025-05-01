package com.manindra.stream;

import java.util.Map;
import java.util.stream.Collectors;

public class CountTheOccurrencesOfEachCharacter {

    public static void main(String[] args) {

        String s1 = "sssssHiiiii";
        Map<Character, Long> collect = s1.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(collect);
    }
}
