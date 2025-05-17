package com.manindra.dynamicprogramming_leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals { // solution 435

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2}, {2,3}, {3,4}, {1,3}})); // Output: 1
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2}, {1,2}, {1,2}})); // Output: 2
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2}, {2,3}})); // Output: 0
        System.out.println(eraseOverlapIntervals(new int[][]{{0,2}, {1,3}, {2,4}, {3,5}, {4,6}})); // Output: 2
    }

    static int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0)
            return 0;

        // Sort the intervals based on the end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 1;

        // end time of the first/current interval
        int previous_interval = 0;

        for (int i = 1; i < intervals.length; i++) {

            // If the start time of the next interval is greater than or equal to
            // the end time of the current interval, then we can keep it
            if (intervals[i][0] >= intervals[previous_interval][1]) {
                previous_interval = i;
                count++;
            }
        }

        // Return the number of intervals to remove
        return intervals.length - count;
    }
}
