package com.manindra.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SplitArray {
    public static void main(String[] args) {
        int[] original = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int splitSize = 3;

        //List<int[]> list = splitArray(original, splitSize);
        List<int[]> list = splitArraySolTwo(original, splitSize);
        list.forEach(splitArray -> System.out.println(Arrays.toString(splitArray)));
    }

    public static List<int[]> splitArray(int[] array, int splitSize) {
        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i < array.length; i += splitSize) {
            int[] subArray = new int[splitSize];

            for (int j = 0; j < splitSize && i + j < array.length; j++) {
                subArray[j] = array[i + j];
            }

            resultList.add(subArray);
        }

        return resultList;
    }

    public static List<int[]> splitArraySolTwo(int[] array, int splitSize) {
        List<int[]> resultList = new ArrayList<>();
        int currentIndex = 0;

        while (currentIndex < array.length) {
            int remaining = array.length - currentIndex;
            int subArraySize = Math.min(splitSize, remaining);
            int[] subArray = Arrays.copyOfRange(array, currentIndex, currentIndex + subArraySize);

            resultList.add(subArray);
            currentIndex += subArraySize;
        }

        return resultList;
    }
}
