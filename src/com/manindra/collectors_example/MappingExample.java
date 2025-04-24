package com.manindra.collectors_example;

import java.util.*;
import java.util.stream.Collectors;

public class MappingExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Group by length, but collect only uppercase names
        Map<Integer, List<String>> result = names.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(String::toUpperCase, Collectors.toList())
                ));

        System.out.println(result);
    }
}

