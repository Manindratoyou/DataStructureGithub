package com.manindra.array;

import java.util.ArrayList;
import java.util.List;

public class ArraySplitter {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int splitSize = 3;

        List<List<Integer>> output = splitArray(input, splitSize);

        for (List<Integer> subList : output) {
            System.out.println(subList);
        }
    }

    public static List<List<Integer>> splitArray(int[] inputArray, int splitSize) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < inputArray.length; i += splitSize) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < i + splitSize && j < inputArray.length; j++) {
                temp.add(inputArray[j]);
            }
            result.add(temp);
        }

        return result;
    }
}
