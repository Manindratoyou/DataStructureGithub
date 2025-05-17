package com.manindra.practice_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOddFilter {

    public static void main(String[] args) {

        int [] input={1,2,3,4,5,6,7,8};

        Map<Boolean, List<Integer>> collect = Arrays.stream(input).boxed().
                collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(collect);

        List<List<Integer>> collect1 = Arrays.stream(input).boxed().
                collect(Collectors.partitioningBy(x -> x % 2 == 0)).
                entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
        System.out.println(collect1);


    }
}
