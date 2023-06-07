package com.manindra.sorting;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class MyCmp implements Comparator<Integer>{


    @Override
    public int compare(Integer o1, Integer o2) {
        return o1%2-o2%2;
    }
}
public class TestFour {

    public static void main(String[] args) {

        Integer [] arr={5,20,10,12};
        Arrays.sort(arr, new MyCmp());
        System.out.println(Arrays.toString(arr));
    }
}
