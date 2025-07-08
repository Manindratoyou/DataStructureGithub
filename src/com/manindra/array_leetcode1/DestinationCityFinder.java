package com.manindra.array_leetcode1;

import java.util.*;

public class DestinationCityFinder { //solution 1436

    public static String destCity(List<List<String>> paths) {
        Set<String> startCities = new HashSet<>();
        for (List<String> path : paths) {
            startCities.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!startCities.contains(path.get(1))) {
                return path.get(1);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        List<List<String>> paths1 = Arrays.asList(
                Arrays.asList("London", "New York"),
                Arrays.asList("New York", "Lima"),
                Arrays.asList("Lima", "Sao Paulo")
        );

        List<List<String>> paths2 = Arrays.asList(
                Arrays.asList("B", "C"),
                Arrays.asList("D", "B"),
                Arrays.asList("C", "A")
        );

        List<List<String>> paths3 = Arrays.asList(
                Arrays.asList("A", "Z")
        );

        System.out.println("Test 1: " + destCity(paths1)); // Expected: "Sao Paulo"
        System.out.println("Test 2: " + destCity(paths2)); // Expected: "A"
        System.out.println("Test 3: " + destCity(paths3)); // Expected: "Z"
    }
}

