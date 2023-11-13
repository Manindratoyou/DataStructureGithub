package com.manindra.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class Solution349 { //intersection of two arrays

    public static void main(String[] args) {
        int [] num1={1,2,2,1};
        int [] num2={2,2};
        int [] intersectionResult=intersection(num1,num2);
        System.out.println("InterSection of two arrays : "+ Arrays.toString(intersectionResult));
    }

    public static int [] intersection(int [] num1,int [] num2){
        //convert arrays to HashSet for faster lookup
        HashSet<Integer> set1=new HashSet<>();
        for (int num : num1)
            set1.add(num);

        //use a hashset to store a common element
        HashSet<Integer> intersectionSet=new HashSet<>();
        for (int num : num2){
            if (set1.contains(num))
                intersectionSet.add(num);
        }

        //convert HashSet to an array
        int [] result=new int[intersectionSet.size()];
        int i=0;
        for (int num : intersectionSet){
            result[i++]=num;
        }
        return result;
    }
}
