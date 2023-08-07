package com.manindra.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortDecending {

    public static void main(String[] args) {

        List<Integer> list= Arrays.asList(10,16,8,56,5,20);
        list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
    }
}
