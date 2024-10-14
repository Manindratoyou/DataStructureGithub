package com.manindra.interview_2;

import java.util.Arrays;

public class SecondLowestArray {

    public static void main(String[] args) {

        int [] arr={-1,-10,20,42,-13,0,100};
        //System.out.println(secondLowest(arr));
        System.out.println(secondLowestSolutionTwo(arr));
    }

    static int secondLowest(int [] arr){
        Arrays.sort(arr);
        return arr[1];
    }


    static int secondLowestSolutionTwo(int [] arr){
        int firstLowest=Integer.MAX_VALUE;
        int secondLowest=Integer.MAX_VALUE;
        for (int i=0;i< arr.length;i++){
            if (arr[i]<firstLowest){
                secondLowest=firstLowest;
                firstLowest=arr[i];
            } else if (arr[i]<secondLowest && arr[i] != firstLowest) {
                secondLowest=arr[i];
            }
        }
        return secondLowest;
    }
}
