package com.manindra.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        ArrayList al=new ArrayList<>();
        al.add(10);
        al.add(20);
        System.out.println(simpleArraySum(al));
    }

    public static int simpleArraySum(List<Integer> ar) {

        int sum=0;
        for(int i=0;i<ar.size();i++){
            sum=sum+ar.get(i);
        }
        return sum;


    }
}
