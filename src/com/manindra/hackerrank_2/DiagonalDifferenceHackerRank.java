package com.manindra.hackerrank_2;

import java.util.ArrayList;
import java.util.List;

public class DiagonalDifferenceHackerRank {

    public static void main(String[] args) {

        List<Integer> li=new ArrayList<>();
        li.add(1);
        li.add(2);
        li.add(3);

        List<Integer> li1=new ArrayList<>();
        li1.add(4);
        li1.add(5);
        li1.add(6);
        // li1.add(1,90);

        List<Integer> li2=new ArrayList<>();
        li2.add(9);
        li2.add(8);
        li2.add(9);
        List<List<Integer>> list=new ArrayList<>();

        list.add(li);
        list.add(li1);
        list.add(li2);

        list.forEach(System.out::print);
        System.out.println();

        System.out.println(diagonalDifference(list));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int d1 = 0;
        int d2 = 0;

        for (int i = 0; i < arr.size(); i++) {
            d1 += arr.get(i).get(i);
            d2 += arr.get(arr.size() - 1 - i).get(i);
        }

        return Math.abs(d1 - d2);
    }
}
