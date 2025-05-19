package com.manindra.practice_stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProductOfFirstTwo {

    public static void main(String[] args) {

        int[] arr = {12, 5, 6, 9, 2, 4};
        int product = findProductOfFirstTwoStream(arr);
        System.out.println(product);

        Integer reduce = Arrays.stream(arr).boxed().collect(Collectors.toList()).
                stream().limit(2)
                .reduce(1, (a, b) -> a * b);
        System.out.println(reduce);

    }

    public static int findProductOfFirstTwo(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }
        return array[0] * array[1];
    }

    public static int findProductOfFirstTwoStream(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }
        return Arrays.stream(array)
                .limit(2)
                .reduce(1, (a, b) -> a * b);
    }
}
