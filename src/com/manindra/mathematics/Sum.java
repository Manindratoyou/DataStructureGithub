package com.manindra.mathematics;

public class Sum {

    public static void main(String[] args) {
        int [] arr={1,2,3,4};
        System.out.println(getSumOne(arr, arr.length));
        System.out.println(getSumTwo(arr, arr.length));
    }
    static int getSumOne(int[] arr,int n){
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        return sum;
    }
    static int getSumTwo(int[] arr,int n){
        if (n%2==0)
            return 0;
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        return sum;
    }
}
