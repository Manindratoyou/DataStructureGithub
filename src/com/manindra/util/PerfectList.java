package com.manindra.util;

import java.util.List;

public class PerfectList {

    public static void main(String[] args) {
        List<Integer> perfectList1 = List.of(1, 3, 5, 7, 9);
        List<Integer> perfectList2 = List.of(2, 4, 6, 8, 10);
        List<Integer> nonPerfectList = List.of(1, 3, 5, 7, 10);

        System.out.println("Is perfectList1 perfect? " + isPerfectList(perfectList1));
        System.out.println("Is perfectList2 perfect? " + isPerfectList(perfectList2));
        System.out.println("Is nonPerfectList perfect? " + isPerfectList(nonPerfectList));
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

