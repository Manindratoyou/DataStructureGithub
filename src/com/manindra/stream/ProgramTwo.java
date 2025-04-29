package com.manindra.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Given a list of integers ,find out all the numbers starting with 1 using Stream function
 */
public class ProgramTwo {

    public static void main(String[] args) {

       /* List<Integer> list= Arrays.asList(10,15,8,49,25,98,32);
        list.stream()
                .map(s->s+"") //convert integer to String
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);*/

        List<Integer> integerList = List.of(10, 20, 15, 30);
        List<String> modifiedList = integerList.stream().map(String::valueOf).
                filter(s -> s.startsWith("1")).
                collect(Collectors.toList());
        System.out.println(modifiedList);
    }
}
