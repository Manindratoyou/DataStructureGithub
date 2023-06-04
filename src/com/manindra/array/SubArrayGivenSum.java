package com.manindra.array;

public class SubArrayGivenSum {

    public static void main(String[] args) {
        int [] arr={1,4,20,3,10,5};
        System.out.println(isSumSubArraySolOne(arr,33));
        System.out.println(isSumSubArraySolTwo(arr,33));


    }
    static boolean isSumSubArraySolOne(int [] arr,int sum){
        for (int i=0;i< arr.length;i++){
            int current=0;
            for (int j=i;j< arr.length;j++){
                current+=arr[j];
                if (current==sum)
                    return true;
            }
        }
        return false;
    }
    static boolean isSumSubArraySolTwo(int [] arr,int sum){

        int start=0,current=0;
        for (int end=0;end<arr.length;end++){
            current+=arr[end];
            while (sum<current){
                current-=arr[start];
                start++;
            }
            if (current==sum)
                return true;
        }
        return false;
    }
}
