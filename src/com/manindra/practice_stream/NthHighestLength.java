package com.manindra.practice_stream;

import java.util.Arrays;
import java.util.Comparator;

public class NthHighestLength {

    public static void main(String[] args) {

        String s = "I am learning Streams API in Java";
        int n=1;
        Integer ans = Arrays.stream(s.split(" ")).map(String::length).
                sorted(Comparator.reverseOrder()).skip(n).findFirst().get();
        System.out.println(ans);

    }
}
