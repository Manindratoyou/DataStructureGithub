package com.manindra.greedy_ds;

import java.util.Arrays;

public class MaxActivity2 {

    public static void main(String[] args) {
        Activity2[] activities = {
                new Activity2(12, 25),
                new Activity2(10, 20),
                new Activity2(20, 30)
        };

        System.out.println(maxActivities(activities));
    }

    static int maxActivities(Activity2[] activities) {
        Arrays.sort(activities, (a, b) -> Integer.compare(a.finish, b.finish));

        int count = 1;
        int lastFinishTime = activities[0].finish;

        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastFinishTime) {
                count++;
                lastFinishTime = activities[i].finish;
            }
        }

        return count;
    }
}

class Activity2 {
    int start, finish;

    Activity2(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

