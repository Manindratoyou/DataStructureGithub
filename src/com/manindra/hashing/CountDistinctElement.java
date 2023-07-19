package com.manindra.hashing;

import java.util.Arrays;
import java.util.HashSet;

public class CountDistinctElement {

    public static void main(String[] args) {
        int [] arr={10,10,20,30};
        Integer [] arr1={10,10,20,30};
        System.out.println(countDistinctElementSolOne(arr));
        System.out.println(countDistinctElementSolTwo(arr));
        System.out.println(countDistinctElementSolThree(arr1));
    }

    static int countDistinctElementSolOne(int [] arr){
        int result=0;
        for (int i=0;i< arr.length;i++){
            boolean flag=false;
            for (int j=0;j< i;j++){
                if (arr[i]==arr[j]){
                    flag=true;
                    break;
                }
            }
            if (flag==false)
                result++;
        }
        return result;
    }
    static int countDistinctElementSolTwo(int [] arr){
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i=0;i< arr.length;i++)
            hashSet.add(arr[i]);
        return hashSet.size();
    }
    static int countDistinctElementSolThree(Integer [] arr){
        HashSet<Integer> hashSet=new HashSet<>(Arrays.asList(arr));
        return hashSet.size();
    }
}
