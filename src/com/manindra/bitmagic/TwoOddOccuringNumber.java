package com.manindra.bitmagic;

public class TwoOddOccuringNumber {

    public static void main(String[] args) {
        int [] arr={3,4,3,4,5,4,4,6,7,7}; //op 5,6

        printOdd(arr);
        printOddSolTwo(arr);

    }

    static void printOdd(int [] arr){
        for (int i=0;i< arr.length;i++){
            int count=0;
            for (int j=0;j< arr.length;j++)
                if (arr[i]==arr[j])
                    count++;
            if (count%2 !=0)
                System.out.println(arr[i]);
        }
    }
    static void printOddSolTwo(int [] arr){

        int x=arr[0];
        for (int i=1;i< arr.length;i++)
            x=x^arr[i];
        int k=(x& ( ~(x-1)));
        int result1=0,result2=0;
        for (int i=0;i< arr.length;i++){
            if ((arr[i] & k) !=0)
                result1=result1^arr[i];
            else
                result2=result2^arr[i];
        }
        System.out.println(result1+ " "+result2);
    }
}
