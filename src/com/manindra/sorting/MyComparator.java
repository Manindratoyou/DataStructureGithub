package com.manindra.sorting;

import java.util.Comparator;

public class MyComparator implements Comparator<Point> {

    public int compare(Point p1,Point p2){
        return p1.x- p2.x;
    }
}
