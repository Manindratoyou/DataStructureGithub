package com.manindra.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//sort the strings by length first and then alphabetically in case of a conflict
public class StringSortExample {

    public static void main(String[] args) {

        Solution1();
        System.out.println("=============");
        Solution2();
        System.out.println("=============");
        Solution3();
    }

    static void Solution1() {
        String[] strings = {"Shriraj", "Arun", "Babita", "Sonu", "Ramu"};

        Arrays.sort(strings, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length()); // sort by length
            } else {
                return s1.compareTo(s2); // sort alphabetically if same length
            }
        });

        System.out.println(Arrays.toString(strings));
    }

    static void Solution2() {
        String[] strings = {"Shriraj", "Arun", "Babita", "Sonu", "Ramu"};

        List<String> sortedList = Arrays.stream(strings)
                .sorted(Comparator
                        .comparingInt(String::length)              // sort by length
                        .thenComparing(Comparator.naturalOrder())) // then alphabetically
                .collect(Collectors.toList());

        System.out.println(sortedList);
    }

    static void Solution3() {
        String[] strings = {"Shriraj", "Arun", "Babita", "Sonu", "Ramu"};

        Arrays.sort(strings, new LengthThenAlphabetComparator());

        System.out.println(Arrays.toString(strings));
    }
}

// Custom comparator: sort by length, then alphabetically
class LengthThenAlphabetComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return Integer.compare(s1.length(), s2.length());
        } else {
            return s1.compareTo(s2);
        }
    }
}
