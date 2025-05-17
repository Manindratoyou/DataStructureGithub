package com.manindra.practice_stream;

import java.util.Arrays;

public class SumOfDistinctElement {

    public static void main(String[] args) {

        int [] arr={1,6,7,8,1,1,8,8,7};

        int sum = Arrays.stream(arr).distinct().sum();
        System.out.println(sum);
    }
}
