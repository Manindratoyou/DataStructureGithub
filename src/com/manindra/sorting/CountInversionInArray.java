package com.manindra.sorting;

public class CountInversionInArray {

    public static void main(String[] args) {
        int [] arr={2,4,1,3,5};
        System.out.println(countInversionSolOne(arr, arr.length));
    }

    static int countInversionSolOne(int [] arr,int n){
        int count=0;
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if (arr[i]>arr[j])
                    count++;
            }
        }
        return count;
    }
}
