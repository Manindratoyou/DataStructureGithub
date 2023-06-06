package com.manindra.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class TestTwo {

    public static void main(String[] args) {

        Point [] arr={new Point(10,20),new Point(3,12),new Point(5,7)};
        Arrays.sort(arr,new MyComparator());
        for (int i=0;i< arr.length;i++)
            System.out.println(arr[i].x+" "+arr[i].y);
    }
}
