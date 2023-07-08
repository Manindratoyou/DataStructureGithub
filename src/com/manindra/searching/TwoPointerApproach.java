package com.manindra.searching;

//find if there is a pair with sum x in a sorted array
public class TwoPointerApproach {

    public static void main(String[] args) {

        int [] arr={2,3,5,8,11,15}; int key=16; //op true (5+11)
        System.out.println(twoPointerNaiveSolOne(arr,key));
        System.out.println(twoPointerApproach(arr,key));

    }

    //best case tc 0(1) key 5 (2,3) , worst case when key not present (n2)
    static boolean twoPointerNaiveSolOne(int [] arr,int key){ //tc 0(n^2) As 0(1)
        for (int i=0;i< arr.length-1;i++)
            for (int j=i+1;j< arr.length;j++)
                if (arr[i]+arr[j]==key)
                    return true;
        return false;
    }

    static boolean twoPointerApproach(int [] arr, int key){ //tc 0(n) as 0(1)
        int i=0,j= arr.length-1;
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
