package com.manindra.stream;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String s1 = "sssssHiiiii";
        Character c1 = s1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors
                        .groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println(c1);
    }
}
