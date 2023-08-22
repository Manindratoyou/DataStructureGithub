package com.manindra.array;

public class MinimumSwaps {

    static int minimumSwap(int [] arr){
        int n= arr.length;
        int swaps=0;
        for (int i=0;i< arr.length;i++){
            //keep swapping until the element is at correct position
            while (arr[i] !=i+1){
                int temp=arr[i];
                arr[i]=arr[temp-1];
                arr[temp-1]=temp;
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        int [] arr1={4,3,1,2};
        //System.out.println(minimumSwap(arr1));

        int [] arr2={2,3,4,1,5};
        System.out.println(minimumSwap(arr1));
    }
}
