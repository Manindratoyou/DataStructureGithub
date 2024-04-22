package com.manindra.util;

import java.util.Arrays;

public class FindDigit {

    public static void main(String[] args) {

        String str = "qwerty1qwerty2";
        str = str.replaceAll("[^0-9]+", " ");
        System.out.println(Arrays.asList(str.trim().split(" ")));

        String sample = "krishna64";
        char[] chars = sample.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            if(Character.isDigit(c)){
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
