package com.manindra.practice_stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicateCharacters {

    public static void main(String[] args) {

        String input="dabcadefg";

        input.chars().distinct().mapToObj(x->(char)x).forEach(System.out::print);
        System.out.println();
        String l =  Arrays.stream(input.split("")).distinct().collect(Collectors.joining());
        System.out.println(l);



    }
}
