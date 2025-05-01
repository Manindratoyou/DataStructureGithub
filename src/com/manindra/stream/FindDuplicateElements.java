package com.manindra.stream;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateElements {

    public static void main(String[] args) {

        //First Way
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 2, 3);
        Set<Integer> duplicates = numbers.stream()
                .filter(n -> Collections.frequency(numbers, n) > 1)
                .collect(Collectors.toSet());
        System.out.println(duplicates); // Output: [2, 3]

        //Second Way
        Set<Integer> set = new LinkedHashSet<>();
        List<Integer> dup = numbers.stream().filter(x -> !set.add(x)).
                collect(Collectors.toList());
        System.out.println(dup);// Output: [2, 3]
    }
}
