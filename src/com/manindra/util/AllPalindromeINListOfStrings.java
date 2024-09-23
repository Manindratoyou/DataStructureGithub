package com.manindra.util;

import java.util.List;
import java.util.stream.Collectors;

public class AllPalindromeINListOfStrings {

    public static void main(String[] args) {

        var list = List.of("madam", "apple", "racecar", "civic");
        System.out.println(findPalindromes(list));
    }

    static List<String> findPalindromes(List<String> list) {
        return list.stream()
                .filter(str -> new StringBuilder(str)
                        .reverse().toString().equals(str))
                .collect(Collectors.toList());
    }
}
