package com.manindra.hashing_leetcode;

import java.util.*;

public class RingsAndRods { //solution 2103

    public int countPoints(String rings) {
        Set<Character>[] rodColors = new HashSet[10]; // rods 0 to 9

        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int rod = rings.charAt(i + 1) - '0';

            if (rodColors[rod] == null) {
                rodColors[rod] = new HashSet<>();
            }

            rodColors[rod].add(color);
        }

        int count = 0;
        for (Set<Character> colors : rodColors) {
            if (colors != null && colors.size() == 3) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        RingsAndRods solution = new RingsAndRods();

        // Test Case 1
        String rings1 = "B0R0G0R9G9B9";
        System.out.println("Test Case 1: " + solution.countPoints(rings1)); // 2

        // Test Case 2
        String rings2 = "B0G0";
        System.out.println("Test Case 2: " + solution.countPoints(rings2)); // 0

        // Test Case 3
        String rings3 = "R0G0B0R1G1B1R2G2B2";
        System.out.println("Test Case 3: " + solution.countPoints(rings3)); // 3

        // Test Case 4
        String rings4 = "R0R0R0R0";
        System.out.println("Test Case 4: " + solution.countPoints(rings4)); // 0
    }
}

