package com.manindra.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListSecondHighest {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(6, 8, 3, 5, 99, 1, 45);

        Iterator<Integer> iterator = list.stream().iterator();

        int maxVal = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        while (iterator.hasNext()) {
            int element = iterator.next();
            if (element > maxVal) {
                secondMax = maxVal; // Update secondMax only when a new maximum is found
                maxVal = element;
            } else if (element > secondMax && element != maxVal) {
                secondMax = element; // Update secondMax if a new second maximum is found
            }

        }
        System.out.println(maxVal);
        System.out.println(secondMax);

    }
}
