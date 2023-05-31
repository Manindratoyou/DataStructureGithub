package com.manindra.array;

public class MaxLenEvenOdd {

    public static void main(String[] args) {

        int [] arr={5,10,20,6,3,8};
        System.out.println(maximumLengthSubArraySolOne(arr));
        System.out.println(maximumEvenOddSolTwo(arr));
    }

    static int maximumLengthSubArraySolOne(int [] arr){
        int result=1;
        for (int i=0;i<arr.length;i++){
            int current=1;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]%2 ==0 && arr[j-1]%2 !=0 ||
                    arr[j]%2 !=0 && arr[j-1]%2 ==0)
                    current++;
                else break;
            }
            result=Math.max(result,current);
        }
        return result;
    }
    static int maximumEvenOddSolTwo(int [] arr){
        int result=1;
        int current=1;
        for (int i=1;i<arr.length;i++){
            if (arr[i]%2==0 && arr[i-1]%2!=0 || arr[i]%2!=0 && arr[i-1]%2==0){
                current++;
                result=Math.max(result,current);
            }
            else
                current=1;
        }
        return result;
    }
}
