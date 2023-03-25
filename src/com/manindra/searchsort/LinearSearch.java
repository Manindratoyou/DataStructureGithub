package com.manindra.searchsort;

public class LinearSearch {

    public static void main(String[] args) {
        int [] arr={5,1,9,2,10,15,20};
        System.out.println(search(arr,arr.length,10));
    }

    static int search(int [] arr,int n ,int x){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==x){
                return i;
            }
        }
        return -1;
    }
}
