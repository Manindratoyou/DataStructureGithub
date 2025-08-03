package com.manindra.array_leetcode2;

public class CarPooling { //solution 1094

    public static void main(String[] args) {
        int[][] trips = {
                {2, 1, 5},
                {3, 3, 7}
        };
        int capacity = 4;
        System.out.println(carPooling(trips, capacity)); // Output: false
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001]; // assuming max location is 1000

        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            diff[from] += numPassengers;   // Pick up
            diff[to] -= numPassengers;     // Drop off
        }

        int currentPassengers = 0;
        for (int i = 0; i < 1001; i++) {
            currentPassengers += diff[i];
            if (currentPassengers > capacity) return false;
        }

        return true;
    }

    public static boolean carPooling2(int[][] trips, int capacity) {
        int[] passengers = new int[1001]; // Max location is 1000

        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            // Mark passengers for each location in the trip
            for (int i = from; i < to; i++) {
                passengers[i] += numPassengers;
                if (passengers[i] > capacity)
                    return false; // Capacity exceeded
            }
        }

        return true;
    }
}

