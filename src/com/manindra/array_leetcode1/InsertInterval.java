package com.manindra.array_leetcode1;

import java.util.Arrays;

public class InsertInterval { //solution 57

    int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][2];
        int i = 0, j = 0;

        // Add all intervals that end before the new interval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result[j++] = intervals[i++];
        }

        // Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }

        result[j++] = newInterval;

        // Add remaining intervals
        while (i < intervals.length) {
            result[j++] = intervals[i++];
        }

        return Arrays.copyOf(result, j);
    }

    public static void main(String[] args) {
        InsertInterval obj = new InsertInterval();

        // Test Case 1
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        System.out.println("Test Case 1: " + Arrays.deepToString(obj.insert(intervals1, newInterval1)));

        // Test Case 2
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        System.out.println("Test Case 2: " + Arrays.deepToString(obj.insert(intervals2, newInterval2)));

        // Test Case 3: Insert before all
        int[][] intervals3 = {{5, 7}, {8, 10}};
        int[] newInterval3 = {1, 2};
        System.out.println("Test Case 3: " + Arrays.deepToString(obj.insert(intervals3, newInterval3)));

        // Test Case 4: Insert after all
        int[][] intervals4 = {{1, 2}, {3, 5}};
        int[] newInterval4 = {6, 8};
        System.out.println("Test Case 4: " + Arrays.deepToString(obj.insert(intervals4, newInterval4)));

        // Test Case 5: Full overlap
        int[][] intervals5 = {{1, 5}};
        int[] newInterval5 = {2, 3};
        System.out.println("Test Case 5: " + Arrays.deepToString(obj.insert(intervals5, newInterval5)));
    }
}
