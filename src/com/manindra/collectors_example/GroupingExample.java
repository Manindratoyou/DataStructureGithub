package com.manindra.collectors_example;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill", "Bob", "Bill");

        // Group names by their starting character
        Map<Character, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println(grouped);
    }
}

