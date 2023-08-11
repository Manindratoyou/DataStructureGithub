package com.manindra.stream;

import java.util.Arrays;
import java.util.List;

public class CubeAndFilter {

    public static void main(String[] args) {

        List<Integer> list=Arrays.asList(4,5,6,7,1,2,3);
        list.stream().map(integer -> integer*integer*integer)
                .filter(integer -> integer>50)
                .forEach(System.out::println);
    }
}
