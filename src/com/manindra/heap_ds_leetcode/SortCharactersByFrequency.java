package com.manindra.heap_ds_leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharactersByFrequency { //solution 451

    public static void main(String[] args) {
        SortCharactersByFrequency obj = new SortCharactersByFrequency();
        System.out.println(obj.frequencySort("tree"));     // "eert" or "eetr"
        System.out.println(obj.frequencySort("cccaaa"));   // "cccaaa" or "aaaccc"
        System.out.println(obj.frequencySort("Aabb"));     // "bbAa" or similar
    }

    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray())
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        /*
        Using Anonymous Inner Class
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
         new Comparator<Map.Entry<Character, Integer>>() {
        @Override
        public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
            return b.getValue() - a.getValue(); // Descending order of frequency
        }
        }
         );

         */

        maxHeap.addAll(freqMap.entrySet());

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return result.toString();
    }

    public String frequencySort2(String s) {
        Map<Character, Long> freqMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return freqMap.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .map(e -> String.valueOf(e.getKey()).repeat(Math.toIntExact(e.getValue())))
                .collect(Collectors.joining());
    }

    //
    static class FrequencyComparator implements Comparator<Map.Entry<Character, Integer>> {
        @Override
        public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
            //return b.getValue() - a.getValue(); // descending order of frequency
            return Integer.compare(b.getValue(), a.getValue());

        }
    }
}

