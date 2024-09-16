package com.manindra.interview_2;

import java.util.LinkedHashMap;
import java.util.Map;

public class PrintCharOccurence {

    public static void main(String[] args) {

        String s="aabcdd";
        printCharOccurence(s);
    }

    static void printCharOccurence(String s){

        //create a linked hash mp to maintain the order of character
        Map<Character,Integer> map=new LinkedHashMap<>();

        //count the frequency of each character in the string
        //and stored in the linked hash map
        for (char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for (Map.Entry<Character,Integer> m: map.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }
    }
}
