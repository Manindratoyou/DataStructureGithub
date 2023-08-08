package com.manindra.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
program to concatenate two stream
 */
public class ConcatenateTwoStream {

    public static void main(String[] args) {

        List<String> list1=Arrays.asList("Java","8");
        List<String> list2=Arrays.asList("explained","through","program");
        Stream<String> concatString=Stream.concat(list1.stream(),list2.stream());
        concatString.forEach(System.out::println);
    }
}
