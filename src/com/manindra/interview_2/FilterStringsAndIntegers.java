package com.manindra.interview_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterStringsAndIntegers {

    public static void main(String[] args) {

        String[] str = {"abc", "123", "456", "xyz"};
        filterStringsAndIntegers(str);
        System.out.println("=====================");
        filterStringsAndIntegersStream(str);

    }

    static void filterStringsAndIntegers(String[] str) {

        List<Integer> integers = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        for (String s : str) {
            if (s.matches("\\d+"))
                integers.add(Integer.parseInt(s));
            else
                strings.add(s);
        }
        System.out.println(integers);
        System.out.println(strings);
    }

    static void filterStringsAndIntegersStream(String[] str) {

        List<String> strings = Arrays.stream(str).
                filter(s -> !s.matches("\\d+")).collect(Collectors.toList());
        List<Integer> integers = Arrays.stream(str).
                filter(s -> s.matches("\\d+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(strings);
        System.out.println(integers);
    }
}
