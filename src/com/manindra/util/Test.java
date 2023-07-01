package com.manindra.util;

public class Test {

    public static void main(String[] args) {

        int [] arr={10,14,10,8,11,6};
        System.out.println(thirdHighest(arr));
    }

    static int thirdHighest(int [] arr){

        int highest=arr[0];
        int secondHighest=arr[0];
        int thirdHighest=arr[0];

        for (int i=0;i<arr.length-1;i++){
            if (arr[0]>highest)
                highest=arr[0];
            thirdHighest=secondHighest;
            secondHighest=highest;
        }
        return thirdHighest;
    }
}
