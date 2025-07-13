package com.manindra.string_leetcode1;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWords { //solution 692

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent(words, k)); // Output: [i, love]
    }

    public static List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count frequency
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Custom comparator in min-heap
        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> {
            int freqCompare = freqMap.get(w1) - freqMap.get(w2); // low freq comes first
            if (freqCompare == 0) {
                return w2.compareTo(w1); // reverse lexicographical
            }
            return freqCompare;
        });

        // Step 3: Keep top k in heap
        for (String word : freqMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll(); // remove less frequent
            }
        }

        // Step 4: Build result from heap
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.reverse(result); // since min-heap
        return result;
    }

    public static List<String> topKFrequentStream(String[] words, int k) {
        Map<String, Long> freq = Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        return freq.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int freqCompare = Long.compare(e2.getValue(), e1.getValue());
                    if (freqCompare == 0) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return freqCompare;
                })
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

