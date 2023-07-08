package com.manindra.searching;

public class TripletInSortedArray {

    public static void main(String[] args) {

        int [] arr={2,3,4,8,9,20,40}; int sum=32;
        System.out.println(tripletInSortedArray(arr,sum));
        System.out.println(tripletInSortedArraySolTwo(arr,sum));

    }

    static boolean tripletInSortedArray(int [] arr,int sum){ //0(n3) As 0(1)
        for (int i=0;i< arr.length-2;i++)
            for (int j=i+1;j<arr.length-1;j++)
                for (int k=j+1;k< arr.length;k++)
                    if (arr[i]+arr[j]+arr[k]==sum)
                        return true;
        return false;
    }
    static boolean tripletInSortedArraySolTwo(int [] arr,int sum){
        for (int i=0;i< arr.length-2;i++)
            if (isPair(arr,sum-arr[i],i+1))
                return true;
        return false;
    }
    static boolean isPair(int [] arr,int key,int startIndex){
        int i=startIndex,j=arr.length-1;
        while (i<j){
            if (arr[i]+arr[j]==key)
                return true;
            else if (arr[i]+arr[j]<key)
                i++;
            else j--;
        }
        return false;
    }
}
