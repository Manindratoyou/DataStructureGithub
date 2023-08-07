package com.manindra.stream;

import java.util.Arrays;
import java.util.List;

public class SortValues {

    public static void main(String[] args) {

        List<Integer> list=Arrays.asList(10,16,8,56,5,20);
        list.stream().sorted().forEach(System.out::println);

    }
}
