package com.manindra.stream;

import java.util.Comparator;
import java.util.List;

public class NthSmallestOrLargestNumber {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
        int n = 2;
        int nthLargest = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(n - 1)
                .findFirst()
                .orElseThrow();
        System.out.println(nthLargest); // Output: 40
    }
}
