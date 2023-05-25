package com.manindra.array;

public class CheckArraySort {

    public static void main(String[] args) {
        int [] arr={8,12,15};
        System.out.println(isSortedSolOne(arr));
        System.out.println(isSortedSolTwo(arr));
    }
    static boolean isSortedSolOne(int [] arr){
        for (int i=0;i< arr.length;i++){
            for (int j=i+1;j< arr.length;j++){
                if (arr[j]<arr[i])
                    return false;
            }
        }
        return true;
    }
    static boolean isSortedSolTwo(int [] arr){
       for (int i=1;i< arr.length;i++){
           if (arr[i]<arr[i-1])
               return false;
       }
       return true;
    }
}
