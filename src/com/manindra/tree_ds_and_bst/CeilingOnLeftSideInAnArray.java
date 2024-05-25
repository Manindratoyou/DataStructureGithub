package com.manindra.tree_ds_and_bst;

import java.util.TreeSet;

public class CeilingOnLeftSideInAnArray { //check this


    public static void main(String[] args) {
        int[] arr = {2, 8, 30, 15, 25, 12};
       // printCeiling(arr, arr.length);
        System.out.println();
        printCeilingEfficient(arr, arr.length);
    }

    public static void printCeiling(int arr[], int n){ //0(n^2) check this code
        System.out.print("-1"+" ");
        for(int i=1;i<n;i++){
            int diff=Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                if(arr[j]>=arr[i])
                    diff=Math.min(diff,arr[j]-arr[i]);
            }
            if(diff==Integer.MAX_VALUE)
                System.out.print("-1"+" ");
            else
                System.out.print((arr[i]+diff)+" ");
        }
    }
    public static void printCeilingEfficient(int arr[], int n){
        System.out.print("-1"+" ");
        TreeSet<Integer> s=new TreeSet<>();
        s.add(arr[0]);
        for(int i=1;i<n;i++){
            if(s.ceiling(arr[i])!=null)
                System.out.print(s.ceiling(arr[i])+" ");
            else
                System.out.print("-1"+" ");
            s.add(arr[i]);
        }
    }
}
