package com.manindra.practice_stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurance {

    public static void main(String[] args) {

        String input = "Mississippi";

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        map.forEach((character, integer) -> System.out.println(character + " " + integer));

        System.out.println("===============");
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        System.out.println("--");
        Map<String, Long> collect = Arrays.stream(input.split("")).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }
}
