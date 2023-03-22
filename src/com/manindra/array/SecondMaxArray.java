package com.manindra.array;

public class SecondMaxArray {

    public static void main(String[] args) {
        int [] arr={9,7,32,34,23,7,76};
        System.out.println(findSecondMax(arr));
    }

    static int findSecondMax(int[] arr){
        int max=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        for (int i=0;i< arr.length;i++){
            if (arr[i]>max){
                secondMax=max;
                max=arr[i];
            } else if (arr[i]>secondMax && arr[i] !=max) {
                secondMax=arr[i];
            }
        }
        return secondMax;
    }
}
