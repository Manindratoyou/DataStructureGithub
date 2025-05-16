package com.manindra.heap_ds_leetcode;

import java.util.*;

public class TaskSchedulerPQ { //solution 621

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCounts = new HashMap<>();
        for (char task : tasks) {
            taskCounts.put(task, taskCounts.getOrDefault(task, 0) + 1);
        }

        // Max heap based on task frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(taskCounts.values());

        int time = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            // Try to execute up to n+1 tasks in this cycle
            while (cycle > 0 && !maxHeap.isEmpty()) {
                temp.add(maxHeap.poll());
                cycle--;
                time++;
            }

            // Decrease frequency and add back if still pending
            for (int count : temp) {
                if (count - 1 > 0) {
                    maxHeap.offer(count - 1);
                }
            }

            if (maxHeap.isEmpty()) break;
            time += cycle; // fill idle time if cycle not fully filled
        }

        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n)); // Output: 8
    }
}

