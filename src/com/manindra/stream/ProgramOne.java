package com.manindra.stream;

import java.util.Arrays;
import java.util.List;

/*
Given a list of integer ,find out all the even number that exists in the list using Stream function?
 */
public class ProgramOne {

    public static void main(String[] args) {

        List<Integer> list= Arrays.asList(10,15,8,49,25,98,32);
        list.stream().filter(integer -> integer%2==0).forEach(System.out::println);
    }
}
