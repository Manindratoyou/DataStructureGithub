package com.manindra.util;

public class ThirdHighest {

    public static void main(String[] args) {

        int [] arr={7,5,8,25,40,65};
        int firstHighest=0;
        int secondHighest=0;
        int thirdHighest=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstHighest) {
                thirdHighest = secondHighest;
                secondHighest = firstHighest;
                firstHighest = arr[i];
            } else if (arr[i] > secondHighest) {
                thirdHighest = secondHighest;
                secondHighest = arr[i];
            } else if (arr[i] > thirdHighest) {
                thirdHighest = arr[i];
            }
        }
        System.out.println(firstHighest);
        System.out.println(secondHighest);
        System.out.println(thirdHighest);
    }

}
