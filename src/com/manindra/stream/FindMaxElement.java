package com.manindra.stream;

import java.util.Arrays;
import java.util.List;

public class FindMaxElement {

    public static void main(String[] args) {

        List<Integer> list= Arrays.asList(10,15,8,49,25,98,32);
        //int max=list.stream().max((o1, o2) -> o1.compareTo(o2)).get();
        int max=list.stream().max(Integer::compareTo).get();
        System.out.println(max);
    }
}
