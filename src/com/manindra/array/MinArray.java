package com.manindra.array;

public class MinArray {

    public static void main(String[] args) {
        int [] arr={9,7,11,65,23,3};
        System.out.println(findMin(arr));
    }
    static int findMin(int[] arr){
        int min=arr[0];
        for (int i=1;i< arr.length;i++){
            if (arr[i]<min)
                min=arr[i];
        }
        return min;
    }
}
