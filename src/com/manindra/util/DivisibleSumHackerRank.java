package com.manindra.util;

import java.util.ArrayList;
import java.util.List;

public class DivisibleSumHackerRank {

    public static void main(String[] args) {

        List<Integer> ar=new ArrayList<>();
        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.add(4);
        ar.add(5);
        ar.add(6);
        System.out.println(divisibleSumPairs(ar.size(),5,ar));


    }

    static int divisibleSumPairs(int n, int k,List<Integer> arr) {//int[] ar
        int count = 0;
        for(int i=0; i< arr.size()-1; i++){
            for(int j=i+1; j< arr.size(); j++){
                if(((arr.get(i)+ arr.get(j))%k)==0){
                    count++;
                }
            }
        }
        return count;
    }
}
