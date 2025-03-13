package com.manindra.corejava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MethodChainingExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("bob");
        names.add("Charlie");
        names.add("david");
        names.add("Eva");

        // Example 1: String manipulation and filtering
        String result = names.stream()
                .filter(name -> name.length() > 3) // Filter names longer than 3 characters
                .map(String::toUpperCase) // Convert to uppercase
                .sorted() // Sort alphabetically
                .collect(Collectors.joining(", ")); // Join with commas

        System.out.println("Result: " + result); // Output: Result: ALICE, CHARLIE, DAVID

        //Example 2: More complex manipulation
        List<Integer> lengths = names.stream()
                .filter(name -> name.toLowerCase().startsWith("a") || name.toLowerCase().startsWith("b"))
                .map(String::length)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Lengths: " + lengths); //Output: Lengths: [3, 5]

        //Example 3: StringBuilder example
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ")
                .append("World!")
                .insert(6, "Beautiful ")
                .reverse();

        System.out.println("String Builder result: " + sb.toString()); //output: !dlroW lufituaeB olleH
    }
}
