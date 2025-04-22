package com.manindra.collectors_example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {

    public static void main(String[] args) {

        //toList()
        List<String> names = Stream.of("Alice", "Bob", "Charlie")
                .collect(Collectors.toList());
        System.out.println(names);

        //joining()
        String joined = Stream.of("Java", "Python", "C++")
                .collect(Collectors.joining(", "));
        System.out.println(joined);
        //groupingBy()
        Map<Integer, List<String>> groupedByLength = Stream.of("a", "bb", "ccc", "dd")
                .collect(Collectors.groupingBy(String::length));
        System.out.println(groupedByLength);
        //toMap()
        Map<String, Integer> map = Stream.of("a", "bb", "ccc")
                .collect(Collectors.toMap(str -> str, String::length));
        System.out.println(map);
    }
}
