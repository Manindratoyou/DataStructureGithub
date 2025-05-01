package com.manindra.stream;

import java.util.List;
import java.util.OptionalDouble;

public class FindTheSumAverageOfListOfNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 3, 4, 5, 6);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        OptionalDouble average = numbers.stream()
                .mapToInt(Integer::intValue).average();
        System.out.println(sum);
        System.out.println(average.getAsDouble());
    }
}
