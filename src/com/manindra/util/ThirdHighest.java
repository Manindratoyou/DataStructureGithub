package com.manindra.util;

public class ThirdHighest {

    public static void main(String[] args) {

        int [] arr={7,5,8,25,40,65};
        int highest=arr[0];
        int secondHighest=arr[0];
        int thirdHighest=arr[0];

        for (int i=1;i< arr.length;i++){
            if (arr[i]>highest) {
                thirdHighest = secondHighest;
                secondHighest = highest;
                highest = arr[i];
            }
        }
        System.out.println("first "+highest);
        System.out.println("second "+secondHighest);
        System.out.println("third "+thirdHighest);

    }
}
