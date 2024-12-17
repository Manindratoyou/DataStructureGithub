package com.manindra.corejava;

import java.util.List;

public class SafeVarargsExample {

    @SafeVarargs
    public static void printAll(List<String>... lists) {
        for (List<String> list : lists) {
            list.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        List<String> list1 = List.of("A", "B");
        List<String> list2 = List.of("C", "D");

        // Safe varargs usage
        printAll(list1, list2);
    }
}

