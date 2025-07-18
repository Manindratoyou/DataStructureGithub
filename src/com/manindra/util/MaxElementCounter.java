package com.manindra.util;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxElementCounter {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 1, 3, 4, 7, 4, 4, 4, 4, 4,7);

        System.out.println("Input List: " + list);

        System.out.println("1. Using Java 8 Stream: " + countUsingStream(list));
        System.out.println("2. Using Loop: " + countUsingLoop(list));
        System.out.println("3. Using Collections.frequency: " + countUsingCollectionsFrequency(list));
        System.out.println("4. Using Collectors.groupingBy: " + countUsingGroupingBy(list));
        System.out.println("5. Using IntSummaryStatistics: " + countUsingSummaryStatistics(list));


        // Count most frequent element
        System.out.println("\n--- Count of Most Frequent Element ---");
        countMostFrequentElement(list);
    }

    // 1. Using Java 8 Stream
    public static long countUsingStream(List<Integer> list) {
        int max = Collections.max(list);
        return list.stream().filter(i -> i == max).count();
    }

    // 2. Using Traditional Loop
    public static int countUsingLoop(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int num : list) {
            if (num > max) {
                max = num;
                count = 1;
            } else if (num == max) {
                count++;
            }
        }
        return count;
    }

    // 3. Using Collections.frequency
    public static int countUsingCollectionsFrequency(List<Integer> list) {
        int max = Collections.max(list);
        return Collections.frequency(list, max);
    }

    // 4. Using Java 8 GroupingBy Collector
    public static long countUsingGroupingBy(List<Integer> list) {
        Map<Integer, Long> freqMap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int max = Collections.max(freqMap.keySet());
        return freqMap.get(max);
    }

    // 5. Using IntSummaryStatistics
    public static long countUsingSummaryStatistics(List<Integer> list) {
        IntSummaryStatistics stats = list.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        int max = stats.getMax();
        return list.stream().filter(i -> i == max).count();
    }

    // 6. Count Most Frequent Element and its Frequency
    public static void countMostFrequentElement(List<Integer> list) {
        Map<Integer, Long> freqMap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Optional<Map.Entry<Integer, Long>> mostFrequent = freqMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        if (mostFrequent.isPresent()) {
            System.out.println("Most frequent element: " + mostFrequent.get().getKey());
            System.out.println("Frequency: " + mostFrequent.get().getValue());
        } else {
            System.out.println("List is empty.");
        }
    }
}

