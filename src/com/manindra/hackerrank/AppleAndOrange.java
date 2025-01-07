package com.manindra.hackerrank;

import java.util.List;

public class AppleAndOrange {

    public static void main(String[] args) {
        // Test case
        List<Integer> apples = List.of(-2, 2, 1);  // Distances from apple tree
        List<Integer> oranges = List.of(5, -6);    // Distances from orange tree
        countApplesAndOrangesJava8(7, 11, 5, 15, apples, oranges); // Expected: 1 1
        countApplesAndOrangesNormal(7, 11, 5, 15, apples, oranges); // Expected: 1 1
        countApplesAndOranges(7, 11, 5, 15, apples, oranges); // Expected: 1 1
    }

    public static void countApplesAndOrangesJava8(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        long appleCount = apples.stream().map(apple -> apple + a) // Calculate final positions of apples
                .filter(position -> position >= s && position <= t) // Filter positions in range
                .count();

        long orangeCount = oranges.stream().map(orange -> orange + b) // Calculate final positions of oranges
                .filter(position -> position >= s && position <= t) // Filter positions in range
                .count();

        System.out.println(appleCount);
        System.out.println(orangeCount);
    }

    public static void countApplesAndOrangesNormal(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int appleCount = 0;
        int orangeCount = 0;

        // Calculate positions of apples and count those within the range
        for (int apple : apples) {
            int position = a + apple;
            if (position >= s && position <= t) {
                appleCount++;
            }
        }

        // Calculate positions of oranges and count those within the range
        for (int orange : oranges) {
            int position = b + orange;
            if (position >= s && position <= t) {
                orangeCount++;
            }
        }

        System.out.println(appleCount);
        System.out.println(orangeCount);
    }

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int count = 0;
        for (int i = 0; i < apples.size(); i++) {
            int sum = a + apples.get(i);
            if (sum >= s && sum <= t) count++;
        }
        System.out.println(count); //no of apples
        count = 0;
        for (int i = 0; i < oranges.size(); i++) {
            int sum = b + oranges.get(i);
            if (sum >= s && sum <= t) count++;
        }
        System.out.println(count);//no of oranges

    }


}

