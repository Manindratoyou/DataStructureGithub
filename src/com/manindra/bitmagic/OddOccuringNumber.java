package com.manindra.bitmagic;

public class OddOccuringNumber {

    public static void main(String[] args) {
        int [] arr={8,7,7,8,8};
        System.out.println(findOdd(arr));
        System.out.println(findOddSolTwo(arr));
    }

    static int findOdd(int [] arr){ //tc o(n^2)
        for (int i=0;i< arr.length;i++){
            int count=0;
            for (int j=0;j< arr.length;j++)
                if (arr[i]==arr[j])
                    count++;
            if (count%2!=0)
                return arr[i];
        }
        return -1;
    }
    static int findOddSolTwo(int [] arr){
        int result=arr[0];
        for (int i=1;i< arr.length;i++)
            result=result^arr[i];
        return result;
    }
}
