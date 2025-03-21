package com.manindra.interview_2;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintCharOccurence { //important

    public static void main(String[] args) {

        String s = "aabcdd";
        printCharOccurence(s);
        String str = "hyderabad";
        printCharOccurence3(str);
        printCharOccurrence2(str);
    }

    static void printCharOccurence(String s) {

        //create a linked hash mp to maintain the order of character
        Map<Character, Integer> map = new LinkedHashMap<>();

        //count the frequency of each character in the string
        //and stored in the linked hash map
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + "" + m.getValue());
        }
    }

    public static void printCharOccurrence2(String s) {
        // Use Java 8 Streams to count character frequency while maintaining insertion order
        Map<Character, Long> map = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));

        // Print character occurrences
        map.forEach((key, value) -> System.out.println(key + "" + value));
    }

    static void printCharOccurence3(String str) {

        Map<String, Long> collect = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        System.out.println(collect);
    }
}
