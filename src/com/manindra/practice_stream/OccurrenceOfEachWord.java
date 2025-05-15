package com.manindra.practice_stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccurrenceOfEachWord {

    public static void main(String[] args) {


        String s= "I am learning Streams API in Java Java";

        Map<String, Long> collect = Arrays.stream(s.split(" ")).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

    }
}
