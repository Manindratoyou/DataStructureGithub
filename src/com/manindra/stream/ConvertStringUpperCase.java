package com.manindra.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertStringUpperCase {

    public static void main(String[] args) {

        List<String> stringList=Arrays.asList("aa","bb","cc","dd");
        stringList.stream().map(String::toUpperCase).
                collect(Collectors.toList()).forEach(System.out::println);

       // stringList.stream().map(s -> s.toUpperCase()).forEach(s-> System.out.print(s+" "));

    }
}
