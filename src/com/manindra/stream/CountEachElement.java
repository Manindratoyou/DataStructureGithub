package com.manindra.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountEachElement {

    public static void main(String[] args) {

        List<String> list=Arrays.asList("AA","BB","CC","DD","AA");
        Map<String,Long> map=list.stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
        System.out.println(map);
    }
}
