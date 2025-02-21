package com.manindra.util;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateFinder {


    public static void main(String[] args) {
        Integer[] genericArray = {1, 2, 3, 2, 4, 1, 5}; // Corrected array initialization
        Set<Integer> duplicates = findDuplicates(genericArray);

        System.out.println("Duplicate elements: " + duplicates);


        String[] stringArray = {"apple", "banana", "apple", "orange", "banana"};
        Set<String> stringDuplicates = findDuplicates(stringArray);
        System.out.println("Duplicate strings: " + stringDuplicates);

    }



    // Streams, Generics, Collections

    public static <T> Set<T> findDuplicates(T[] array) {
        Set<T> seenRecords = new HashSet<>();

        return Arrays.stream(array)
                .filter(val -> !seenRecords.add(val))
                .collect(Collectors.toSet());
    }

    public static <T extends Comparable<T>> void findDuplicates2(T[] arr) {
        // Sort the array
        Arrays.sort(arr);

        // Find duplicates by checking consecutive elements
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i - 1]) == 0) {
                System.out.print(arr[i] + ",");
            }
        }
    }

    //find duplicate between generic type
    public static <T> Set<T> duplicateFind3(T[] arr){
        List<T> list = Arrays.stream(arr).collect(Collectors.toList());
        Map<T,Long> frequencyMap= list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        return frequencyMap.entrySet().stream().filter(entry->entry.getValue()>1)
                .map(Map.Entry::getKey).collect(Collectors.toSet());
    }

}
