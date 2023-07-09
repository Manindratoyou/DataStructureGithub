package com.manindra.util;

import java.util.Arrays;
import java.util.Comparator;

//sort the strings by length first and then alphabetically in case of a conflict
public class StringSortExample1 {

    public static void main(String[] args) {
        String[] strings = {"Shriraj", "Arun", "Babita", "Sonu", "Ramu"};

        Arrays.sort(strings, Comparator.comparingInt(String::length).thenComparing(String::compareTo));
        //Arrays.sort(strings, Comparator.comparing(String::length).thenComparing(String::compareTo));

        for (String str : strings) {
            System.out.println(str);
        }
    }
}
