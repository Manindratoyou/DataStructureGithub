package com.manindra.sorting;

import java.util.Arrays;
import java.util.Collections;

public class TestThree {

    public static void main(String[] args) {
        //wrapper class example
        Integer [] arr={5,20,10,12};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }
}
