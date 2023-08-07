package com.manindra.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicates {

    public static void main(String[] args) {

        int [] arr={10,10,30,30,50,50};
        containsDuplicates(arr).forEach(System.out::println);
        System.out.println("========");

        List<Integer> list= Arrays.asList(10,10,30,30,50,50);
        list.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);

    }

    static Set<Integer> containsDuplicates(int [] arr){
        Set<Integer> set=Arrays.stream(arr).boxed().collect(Collectors.toSet());
        return set;
    }
}
