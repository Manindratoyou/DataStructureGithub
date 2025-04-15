package com.manindra.heap_ds_leetcode;

import java.util.*;

public class HighFive { //solution 1086

    public static void main(String[] args) {
        int[][] items = {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60},
                {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}};

        int[][] result = highFive(items);
        for (int[] pair : result) {
            System.out.println("ID: " + pair[0] + ", Average of Top 5: " + pair[1]);
        }
    }

    public static int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        // Store scores in min-heaps
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];

            map.putIfAbsent(id, new PriorityQueue<>());

            PriorityQueue<Integer> pq = map.get(id);
            pq.offer(score);

            // Keep only top 5 scores
            if (pq.size() > 5) {
                pq.poll(); // remove the smallest
            }
        }

        // Prepare result
        int[][] result = new int[map.size()][2];
        int i = 0;
        for (int id : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(id);
            int sum = 0;
            for (int score : pq) {
                sum += score;
            }
            result[i++] = new int[]{id, sum / 5};
        }

        // Sort by student ID
        Arrays.sort(result, Comparator.comparingInt(a -> a[0]));
        return result;
    }

    public static int[][] highFive2(int[][] items) {
        // TreeMap keeps keys sorted
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        // Group top 5 scores using min-heaps
        Arrays.stream(items).forEach(item -> {
            int id = item[0];
            int score = item[1];

            map.putIfAbsent(id, new PriorityQueue<>());
            PriorityQueue<Integer> pq = map.get(id);
            pq.offer(score);

            if (pq.size() > 5) pq.poll(); // remove lowest if > 5 scores
        });

        // Build result array
        return map.entrySet().stream().map(entry -> {
            int id = entry.getKey();
            int sum = entry.getValue().stream().mapToInt(Integer::intValue).sum();
            return new int[]{id, sum / 5};
        }).toArray(int[][]::new);
    }
}

