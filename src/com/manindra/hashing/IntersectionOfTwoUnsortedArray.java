package com.manindra.hashing;

import java.util.HashSet;

public class IntersectionOfTwoUnsortedArray {

    public static void main(String[] args) {
        int [] arr1={10,15,20,25,30,50};
        int [] arr2={30,5,15,80};
        intersectionOfTwoUnsortedArray(arr1,arr2,arr1.length,arr2.length);
        intersectionOfTwoUnsortedArraySolTwo(arr1,arr2);

    }

    static void intersectionOfTwoUnsortedArray(int [] arr1,int[] arr2,int arr1Len,int arr2Len){
        for (int i=0;i<arr1Len;i++){
            boolean flag=false;
            for (int j=0;j<arr2Len;j++){
                if (arr1[i]==arr2[j]){
                    flag=true;
                    break;
                }
            }
            if (flag==true)
                System.out.print(arr1[i]+" ");
        }
    }
    static void intersectionOfTwoUnsortedArraySolTwo(int [] arr1,int[] arr2){
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i=0;i< arr2.length;i++){
            hashSet.add(arr2[i]);
        }
        for (int i=0;i< arr1.length;i++){
            if (hashSet.contains(arr1[i]))
                System.out.print(arr1[i]+" ");
        }
    }
}
