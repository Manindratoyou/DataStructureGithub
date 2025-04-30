package com.manindra.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionListOddEven {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partitioned);
        // Output: {false=[1, 3, 5], true=[2, 4, 6]}
    }
}
