package com.manindra.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program3 {

    public static void main(String[] args) {
        String[] names = {"James", "Sam", "JaMes", "Joe", "JOE", "James"};

        // Count occurrences of each name
        Map<String, Long> nameCounts = Arrays.stream(names)
                .map(String::toLowerCase) // Convert names to lowercase for case-insensitive counting
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Print the counts
        nameCounts.forEach((name, count) -> System.out.println(name + ": " + count));
    }

    static void count(String [] arr){

        Map<String ,Integer> map=new HashMap<>();
        for (String s: arr){
            s=s.toLowerCase();
            map.put(s, map.getOrDefault(s,0)+1);
        }
        for (Map.Entry<String,Integer> m:map.entrySet()){
            System.out.println(m.getKey()+"+"+m.getValue());
        }
    }
}
