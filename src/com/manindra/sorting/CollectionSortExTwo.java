package com.manindra.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSortExTwo {

    public static void main(String[] args) {

        List<Point> list=new ArrayList<>();
        list.add(new Point(5,10));
        list.add(new Point(2,20));
        list.add(new Point(10,30));
        Collections.sort(list);
        for (Point p: list) {
            System.out.println(p.x+" "+p.y);
        }
        System.out.println("=============");
        Collections.sort(list,new MyComparator());
        for (Point p: list) {
            System.out.println(p.x+" "+p.y);
        }
    }
}
