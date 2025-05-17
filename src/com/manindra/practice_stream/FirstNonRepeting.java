package com.manindra.practice_stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeting {

    public static void main(String[] args) {


        String s="Hello World";

        String s1 = Arrays.stream(s.split("")).filter(c -> s.indexOf(c) == s.lastIndexOf(c)).findFirst().get();
        System.out.println(s1);

        Map<Character, Long> collect = s.chars().mapToObj(c -> (char) c).
                collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,Collectors.counting()));
        //Character c = collect.entrySet().stream().filter(m -> m.getValue() >=1).  //first repeating
        Character c = collect.entrySet().stream().filter(m -> m.getValue() == 1).
                map(m -> m.getKey()).findFirst().get();
        System.out.println(c);
    }
}
