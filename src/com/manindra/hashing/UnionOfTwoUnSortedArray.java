package com.manindra.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoUnSortedArray {

    public static void main(String[] args) {
        int [] arr1={10,30,10};
        int [] arr2={5,10,5};

        Integer [] arr3={10,30,10};
        Integer [] arr4={5,10,5};

        System.out.println(unionOfTwoUnSortedArraySolOne(arr1,arr2));
        System.out.println(unionCountDistinct(arr1,arr2));
        System.out.println(unionCountDistinctSolThree(arr3,arr4));
    }

    static int unionOfTwoUnSortedArraySolOne(int [] arr1,int [] arr2){ // naive solution
        int [] dist=new int[arr1.length+arr2.length];
        int i;
        for (i=0;i< arr1.length;i++){
            dist[i]=arr1[i];
        }
        for (int j=0;j< arr2.length;j++){
            dist[i]=arr2[j];
            i++;
        }
        int result=1;
        Arrays.sort(dist);//sorting the element for removing duplicates
        for (int k=1;k<dist.length;k++){ //removing duplicate element
            if (dist[k]!=dist[result-1]){
                dist[result]=dist[k];
                result++;
            }
        }
        return result;
    }

    static int unionCountDistinct(int [] arr1,int [] arr2){
        Set<Integer> set=new HashSet<>();
        for (int x: arr1)
            set.add(x);
        for (int x:arr2)
            set.add(x);
        return set.size();
    }

    static int unionCountDistinctSolThree(Integer [] arr1,Integer [] arr2){
       Set<Integer> set= new HashSet<>(Arrays.asList(arr1));
       set.addAll(Arrays.asList(arr2));
       return set.size();
    }
}
