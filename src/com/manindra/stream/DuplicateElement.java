package com.manindra.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
how to find duplicates element in a given integers list using stream function.
 */
public class DuplicateElement {

    public static void main(String[] args) {

        List<Integer> list=Arrays.asList(10,15,8,49,25,98,32,15,8,49);

        Set<Integer> set=new HashSet<>();
        list.stream().
                filter(n-> !set.add(n)).
                forEach(System.out::println);

        /*Set<Integer> set=list.stream().collect(Collectors.toSet());
        set.forEach(System.out::println);*/
    }
}
