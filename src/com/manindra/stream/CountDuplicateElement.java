package com.manindra.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDuplicateElement {

    public static void main(String[] args) {

        List<String> list= Arrays.asList("AA","BB","CC","DD","AA");
        Map<String,Long> map=list.stream().filter(x-> Collections.frequency(list,x)>1).collect
                (Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);
    }

    public static void main2(String[] args) {
        List<String> list = Arrays.asList("AA", "BB", "CC", "DD", "AA");

        // Step 1: Count occurrences of all elements
        Map<String, Long> frequencyMap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Step 2: Filter to keep only duplicates
        Map<String, Long> duplicates = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(duplicates);
    }
}
