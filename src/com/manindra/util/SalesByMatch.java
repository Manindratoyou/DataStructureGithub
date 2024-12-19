package com.manindra.util;

import java.util.*;
import java.util.stream.Collectors;

public class SalesByMatch {

    public static void main(String[] args) {
        // Test case
        List<Integer> socks = Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20);  // Expected: 3
        System.out.println("Java 8 Approach: " + sockMerchantJava8(socks.size(), socks));
        System.out.println("Normal  Approach: " + sockMerchantNormal(socks.size(), socks));
    }

    public static int sockMerchantJava8(int n, List<Integer> ar) {
        // Group by color and count occurrences
        Map<Integer, Long> sockCounts = ar.stream()
                .collect(Collectors.groupingBy(color -> color, Collectors.counting()));

        // Calculate the total pairs
        int totalPairs = sockCounts.values().stream()
                .mapToInt(count -> (int) (count / 2))
                .sum();

        return totalPairs;
    }

    public static int sockMerchantNormal(int n, List<Integer> ar) {
        // Use a HashMap to count occurrences of each sock color
        Map<Integer, Integer> sockCounts = new HashMap<>();

        for (int sock : ar) {
            sockCounts.put(sock, sockCounts.getOrDefault(sock, 0) + 1);
        }

        // Calculate the total pairs
        int totalPairs = 0;
        for (int count : sockCounts.values()) {
            totalPairs += count / 2;
        }

        return totalPairs;
    }

}

