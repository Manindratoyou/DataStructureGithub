package com.manindra.util;

import java.util.ArrayList;
import java.util.List;

public class PerfectSublists {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 3, 6, 9, 12);

        int perfectSublists = countPerfectSublists(numbers);
        System.out.println("Number of perfect sub-lists: " + perfectSublists);
    }

    public static int countPerfectSublists(List<Integer> numbers) {
        int count = 0;

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 2; j < numbers.size(); j++) {
                List<Integer> sublist = numbers.subList(i, j + 1);
                if (isPerfectList(sublist)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isPerfectList(List<Integer> numbers) {
        if (numbers.size() < 3) {
            return false; // Minimum of 3 numbers is required
        }

        int commonDifference = numbers.get(1) - numbers.get(0);

        for (int i = 2; i < numbers.size(); i++) {
            if (numbers.get(i) - numbers.get(i - 1) != commonDifference) {
                return false; // Difference between any 2 adjacent numbers should be the same
            }
        }
        return true;
    }

}

