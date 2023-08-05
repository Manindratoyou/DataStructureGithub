package com.manindra.stream;

import java.util.Arrays;
import java.util.List;

public class FindFirstElement {

    public static void main(String[] args) {

        List<Integer> list=Arrays.asList(10,15,20);
        list.stream().findFirst().ifPresent(System.out::println);
    }
}
