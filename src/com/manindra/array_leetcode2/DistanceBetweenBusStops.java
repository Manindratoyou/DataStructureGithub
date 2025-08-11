package com.manindra.array_leetcode2;

import java.util.stream.IntStream;

public class DistanceBetweenBusStops { //solution 1184

    public static void main(String[] args) {
        int[] distance = {1, 2, 3, 4};
        System.out.println(distanceBetweenBusStops(distance, 0, 1)); // 1
        System.out.println(distanceBetweenBusStops(distance, 0, 2)); // 3
        System.out.println(distanceBetweenBusStops(distance, 0, 3)); // 4
    }

    // Normal approach
    static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        int clockwise = 0;
        int total = 0;

        for (int i = 0; i < distance.length; i++) {
            total += distance[i];
            if (i >= start && i < destination) {
                clockwise += distance[i];
            }
        }

        return Math.min(clockwise, total - clockwise);
    }

    static int distanceBetweenBusStops2(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        int clockwise = IntStream.range(start, destination)
                .map(i -> distance[i])
                .sum();

        int total = IntStream.of(distance).sum();

        return Math.min(clockwise, total - clockwise);
    }
}

