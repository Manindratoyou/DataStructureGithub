package com.manindra.sorting;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class KthSmallestArray {

    public static void main(String[] args) {
        //int [] arr={10,3,5,20};
        int [] arr={10,4,5,8,11,6,26};
        //System.out.println(kthSmallestElementSolOne(arr,2));
        //int index=kthSmallestElementSolTwo(arr,3);
        //System.out.println(arr[index]);
        int value=kthSmallestElementSolThree(arr,3);
        System.out.println(value);
    }

    static int kthSmallestElementSolOne(int [] arr,int k){
        Arrays.sort(arr);
        return arr[k-1];
    }

    //check this code
    static int kthSmallestElementSolTwo(int [] arr,int k){
        int low=0, high=arr.length-1;
        while (low <= high){
            int partition=lomutoPartition(arr,low,high);
            if (partition == k-1)
                return partition;
            else if (partition>k-1)
                high = partition-1;
            else
                low = partition+1;
        }
        return -1;
    }
    static int kthSmallestElementSolThree(int [] arr,int k){
        Set<Integer> integerSet=new TreeSet<>();
        for (int i=0;i<arr.length-1;i++){
            integerSet.add(arr[i]);
        }
        Iterator<Integer> itr = integerSet.iterator();
        int value = 0;
        for(int i = 0; itr.hasNext(); i++) {
            value = itr.next();
            if (i == k-1) {
                break;
            }
        }
        return value;
    }

    static int lomutoPartition(int [] arr,int low,int high){
        int pivot=arr[high];
        int i=low-1;
        for (int j=low;j<=high-1;j++){
            if (arr[j]<pivot){
                i++;
                //swap arr[i] with arr[j]
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        //swap arr[i+1] with arr[high] for pivot element
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;// return pivot element
    }

}
