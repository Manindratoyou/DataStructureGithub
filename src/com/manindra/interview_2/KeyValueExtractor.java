package com.manindra.interview_2;

import java.util.*;
import java.util.stream.Collectors;

public class KeyValueExtractor {

    public static void main(String[] args) {
        String str = "Cargo:1234King,transport:0987Ace";
        System.out.println(keyValueExtractor(str));
    }

    static Map<String,String> keyValueExtractor(String input){
        // Split the string into key-value pairs
        String[] pairs = input.split(",");

        // Create a map to store the key-value pairs
        Map<String, String> map = new HashMap<>();

        for (String pair : pairs) {
            // Split each pair into key and value
            String[] keyValue = pair.split(":");
            if (keyValue.length == 2) {
                map.put(keyValue[0], keyValue[1]);
            }
        }

        // Print the map
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        return map;
    }

    static Map<String,String> keyValueExtractor2(String input){

        // Process the string and collect into a map
        Map<String, String> map = Arrays.stream(input.split(","))
                .map(pair -> pair.split(":"))
                .filter(keyValue -> keyValue.length == 2)
                .collect(Collectors.toMap(keyValue -> keyValue[0], keyValue -> keyValue[1]));

        // Print the map
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        return map;
    }
}

