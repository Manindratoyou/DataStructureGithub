package com.manindra.stream;

import java.util.Comparator;
import java.util.List;

public class LongestStringInList {

    public static void main(String[] args) {

        List<String> strings = List.of("short", "medium", "longest", "tiny");
        String longest = strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println(longest); // Output: "longest"
    }
}
