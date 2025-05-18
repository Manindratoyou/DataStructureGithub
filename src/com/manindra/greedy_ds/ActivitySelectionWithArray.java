package com.manindra.greedy_ds;

import java.util.*;

public class ActivitySelectionWithArray {

    public static void main(String[] args) {
        int[][] activities = {
                {3, 8},
                {2, 4},
                {1, 3},
                {10, 11}
        };

        List<int[]> selected = selectActivities(activities);
        System.out.print("Selected Activities: ");
        for (int[] activity : selected) {
            System.out.print(Arrays.toString(activity) + " ");
        }
    }

    public static List<int[]> selectActivities(int[][] activities) {
        // Sort activities by end time
        Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));

        List<int[]> result = new ArrayList<>();
        int lastEndTime = -1;

        for (int[] activity : activities) {
            if (activity[0] >= lastEndTime) {
                result.add(activity);
                lastEndTime = activity[1];
            }
        }

        return result;
    }
}

