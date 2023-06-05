package com.manindra.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraysSortExTwo {

    public static void main(String[] args) {
        int [] arr={5,30,20,10,8};
        Arrays.sort(arr,1,4);
        System.out.println(Arrays.toString(arr));
    }
}
