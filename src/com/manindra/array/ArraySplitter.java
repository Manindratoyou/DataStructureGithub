package com.manindra.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySplitter {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int splitSize = 3;

        List<int[]> output = splitArray(input, splitSize);

        for (int[] subarray : output) {
            System.out.println(Arrays.toString(subarray));
        }
    }

    public static List<int[]> splitArray(int[] input, int splitSize) {
        List<int[]> output = new ArrayList<>();

        int startIndex = 0;
        while (startIndex < input.length) {
            int endIndex = Math.min(startIndex + splitSize, input.length);
            int[] subarray = Arrays.copyOfRange(input, startIndex, endIndex);
            output.add(subarray);
            startIndex += splitSize;
        }
        return output;
    }
}
