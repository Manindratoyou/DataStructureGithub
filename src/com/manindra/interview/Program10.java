package com.manindra.interview;

import java.util.Optional;

public class Program10 {

    public static void main(String[] args) {
        String str=null ; //"hello"
        Optional<String> optionalNull = Optional.ofNullable(str);
        String defaultValue = optionalNull.map(String::toUpperCase).
                orElse("Default value");
        System.out.println(defaultValue);
    }
}
