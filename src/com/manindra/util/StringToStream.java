package com.manindra.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringToStream {

    public static void main(String[] args) {

        //Method 1: Using chars() method in Java 8 and later:
        String str = "example";
        IntStream stream = str.chars();

        //Method 2: Using codePoints() method in Java 8 and later:
        String str1 = "example";
        IntStream stream1 = str.codePoints();

        //Method 3: Using chars() method with mapToObj() in Java 8 and later:
        String str2 = "example";
        Stream<Character> stream2 = str.chars().mapToObj(c -> (char) c);

        //Method 4: Using chars() method with mapToObj() and collect() in Java 8 and later:
        String str3 = "example";
        List<Character> charList = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        // Method 5: Using Stream.of() with toCharArray() in Java 8 and later:
        String str4 = "example";
        Stream<Character> stream4 = str4.chars().mapToObj(c -> (char) c);


        // Method 6: Using Arrays.stream() with toCharArray() in Java 8 and later:
        String str5 = "example";
        IntStream stream5 = str5.chars();

        //Method 7: Using Pattern and splitAsStream() in Java 8 and later:
        String str6 = "example";
        Stream<String> stream7 = Pattern.compile("").splitAsStream(str6);

    }
}
