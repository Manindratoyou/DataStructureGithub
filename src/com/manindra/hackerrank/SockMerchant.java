package com.manindra.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SockMerchant {

    public static void main(String[] args) {

        List<Integer> arr=List.of(10,20,20,10,10,30,50,10,20);
        int n=arr.size();

        int pairs=sockMerchant(n,arr);
        System.out.println(pairs);
    }

    static int sockMerchant(int n,List<Integer> arr){
        Map<Integer,Integer> colourCount=new HashMap<>();

        for(int color : arr){
            colourCount.put(color,colourCount.getOrDefault(color,0)+1);
        }

        int pairCount=0;
        for(int count : colourCount.values())
            pairCount+=count/2;

        return pairCount;
    }
}
