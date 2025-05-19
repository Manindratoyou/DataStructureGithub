package com.manindra.practice_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNumericStrings {

    public static void main(String[] args) {

        String[] s = {"abc", "123", "456", "xyz"};

        List<String> collect = Arrays.stream(s).
                filter(s1 -> s1.matches("\\d+")).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println();

        List<Integer> collect1 = Arrays.stream(s).
                filter(x -> x.matches("[0-9]+")).map(Integer::valueOf).
                collect(Collectors.toList());
        System.out.println(collect1);
    }
}
