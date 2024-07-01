package com.manindra.leetcodemedium_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals { // solution 56

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();

        int[][] intervals1 = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] intervals2 = {
                {1, 4},
                {4, 5}
        };

        // Test with intervals1
        int[][] result1 = mergeIntervals.merge(intervals1);
        System.out.println("Merged Intervals 1:");
        for (int[] interval : result1) {
            System.out.println(Arrays.toString(interval));
        }

        // Test with intervals2
        int[][] result2 = mergeIntervals.merge(intervals2);
        System.out.println("Merged Intervals 2:");
        for (int[] interval : result2) {
            System.out.println(Arrays.toString(interval));
        }
    }

    int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                // Overlapping intervals, update the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
