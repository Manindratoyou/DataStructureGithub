package com.manindra.stream;

import java.util.List;
import java.util.stream.Collectors;

public class FlattenListOfLists {

    public static void main(String[] args) {
        List<List<Integer>> nestedList = List.of(List.of(1, 2), List.of(3, 4), List.of(5));
        List<Integer> flatList = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flatList); // Output: [1, 2, 3, 4, 5]
    }
}
