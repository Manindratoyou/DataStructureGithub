package com.manindra.stream;

import java.util.Arrays;

public class SortAndConvert {

    public static void main(String[] args) {

        int [] arr={99,55,203,99,4,91};
        //sorted the array using parallelSort
        Arrays.parallelSort(arr);
        //convert it into stream and then print using forEach
        Arrays.stream(arr).forEach(s-> System.out.print(s+" "));
    }
}
