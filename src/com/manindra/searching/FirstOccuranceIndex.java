package com.manindra.searching;

public class FirstOccuranceIndex {

    public static void main(String[] args) {
        int [] input={1,10,10,10,20,20,40};
        int key=20;
        System.out.println(firstOccuranceSolOne(input,key));
    }

    static int firstOccuranceSolOne(int [] arr, int key){
        for (int i=0;i< arr.length;i++)
            if (arr[i]==key)
                return i;
        return -1;
    }
}
