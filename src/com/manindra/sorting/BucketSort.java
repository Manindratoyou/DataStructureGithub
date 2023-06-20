package com.manindra.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class BucketSort {

    public static void main(String[] args) {
        int [] arr={30,40,10,80,5,12,70};
        bucketSort(arr, arr.length, 4);
        System.out.println(Arrays.toString(arr));
    }

    static void bucketSort(int [] arr, int n, int k){
        int max_val=arr[0];
        for (int i=1;i<n;i++)
            max_val=Math.max(max_val,arr[i]);
        max_val++;

        Vector<Integer> [] bucket=new Vector[n];

        for (int i=0;i<n;i++)
            bucket[i]=new Vector<>();

        for (int i=0;i<n;i++){
            int idx=(arr[i]*k)/max_val;
            bucket[idx].add(arr[i]);
        }
        for (int i=0;i<k;i++)
            Collections.sort(bucket[i]);

        int index=0;
        for (int i=0;i<k;i++){
            for (int j=0;j<bucket[i].size();j++)
                arr[index++]=bucket[i].get(j);
        }
    }
}
