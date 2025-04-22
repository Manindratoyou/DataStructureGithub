package com.manindra.collectors_example;

import java.util.*;
import java.util.stream.Collectors;

public class PartitioningExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 25, 30, 17, 40, 19);

        // Partition numbers into even and odd
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println(partitioned);
    }
}

