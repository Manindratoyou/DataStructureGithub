package com.manindra.stream;

import java.util.stream.Collectors;

public class ProgramThree {

    public static void main(String[] args) {

        String inputString = "abcddddeeefdyaa";

        String result = inputString.chars()
                .distinct()
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());

        System.out.println("Original String: " + inputString);
        System.out.println("String after removing duplicates: " + result);
    }
}
