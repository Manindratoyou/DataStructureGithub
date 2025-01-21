package com.manindra.hackerrank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BeautifulTriplets {
    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 2, 4, 5, 7, 8, 10);
        int d = 3; // Difference
        //System.out.println("Number of beautiful triplets: " + beautifulTriplets(d, arr));
        System.out.println("Number of beautiful triplets: " + beautifulTriplets2(d, arr));
    }

    public static int beautifulTriplets(int d, List<Integer> arr) {
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            int first = arr.get(i);
            int second = first + d;
            int third = first + 2 * d;

            // Check if the next two numbers exist in the array
            if (arr.contains(second) && arr.contains(third)) {
                count++;
            }
        }
        return count;
    }

    public static int beautifulTriplets2(int d, List<Integer> arr) {
        Set<Integer> values = new HashSet<>(arr);
        return (int) arr.stream()
                .filter(x -> values.contains(x + d) && values.contains(x + 2 * d))
                .count();
    }
}

