package com.manindra.stream;

import java.util.Arrays;
import java.util.List;

public class FindTheTotalNumberOfElements {

    public static void main(String[] args) {

        List<Integer> list=Arrays.asList(10,20,30,40);
        long count=list.stream().count();
        System.out.println(count);
    }
}
