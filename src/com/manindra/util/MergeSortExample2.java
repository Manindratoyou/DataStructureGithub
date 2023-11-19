package com.manindra.util;

import java.util.Arrays;

public class MergeSortExample2 {

    public static void main(String[] args) {

        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original Array " + Arrays.toString(array));

        mergeSort(array);

        System.out.println("Sorted Array " + Arrays.toString(array));
    }

    static void mergeSort(int [] array){

        if (array==null || array.length==0) return;

        int [] result=Arrays.stream(array).parallel().sorted().toArray();

        System.arraycopy(result,0,array,0,array.length);

    }


}
