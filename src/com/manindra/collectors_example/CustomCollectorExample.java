package com.manindra.collectors_example;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollectorExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("a", "bb", "ccc");

        // Custom collector: Join with " | " separator using StringBuilder
        Collector<String, StringBuilder, String> customCollector = Collector.of(
                StringBuilder::new,
                (sb, s) -> {
                    if (sb.length() > 0) sb.append(" | ");
                    sb.append(s);
                },
                StringBuilder::append,
                StringBuilder::toString
        );

        String result = names.stream().collect(customCollector);
        System.out.println(result); // Output: a | bb | ccc
    }
}

