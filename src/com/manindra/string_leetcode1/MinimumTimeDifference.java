package com.manindra.string_leetcode1;

import java.util.*;

public class MinimumTimeDifference { //solution 539

    public static void main(String[] args) {
        List<String> timePoints1 = Arrays.asList("23:59", "00:00");
        System.out.println(findMinDifference(timePoints1)); // 1

        List<String> timePoints2 = Arrays.asList("01:01", "02:01", "03:00");
        System.out.println(findMinDifference(timePoints2)); // 59
    }

    public static int findMinDifference(List<String> timePoints) {
        List<Integer> minutesList = new ArrayList<>();

        // Convert all to minutes
        for (String time : timePoints) {
            minutesList.add(toMinutes(time));
        }

        // Sort times
        Collections.sort(minutesList);

        int minDiff = Integer.MAX_VALUE;

        // Compare consecutive times
        for (int i = 1; i < minutesList.size(); i++) {
            minDiff = Math.min(minDiff, minutesList.get(i) - minutesList.get(i - 1));
        }

        // Compare circular difference (last - first across midnight)
        int first = minutesList.get(0);
        int last = minutesList.get(minutesList.size() - 1);
        minDiff = Math.min(minDiff, 24 * 60 - last + first);

        return minDiff;
    }


    // Convert "HH:MM" to minutes
    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

}
