package com.manindra.greedy_ds;

import java.util.*;

public class ActivitySelection {

    static class Activity {
        int start, end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    public static List<Activity> selectActivities(List<Activity> activities) {
        // Sort by end time
        activities.sort(Comparator.comparingInt(a -> a.end));

        List<Activity> result = new ArrayList<>();
        int lastEndTime = -1;

        for (Activity activity : activities) {
            if (activity.start >= lastEndTime) {
                result.add(activity);
                lastEndTime = activity.end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Activity> activities = Arrays.asList(
                new Activity(3, 8),
                new Activity(2, 4),
                new Activity(1, 3),
                new Activity(10, 11)
        );

        List<Activity> selected = selectActivities(activities);
        System.out.println("Selected Activities: " + selected);
    }
}

