package com.manindra.stream;

import java.util.Arrays;
import java.util.List;

/*
Given a list of integers ,find out all the numbers starting with 1 using Stream function
 */
public class ProgramTwo {

    public static void main(String[] args) {

        List<Integer> list= Arrays.asList(10,15,8,49,25,98,32);
        list.stream()
                .map(s->s+"") //convert integer to String
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);
    }
}
