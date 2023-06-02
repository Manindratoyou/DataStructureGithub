package com.manindra.array;

public class MajorityElement {

    public static void main(String[] args) {
        int [] arr={8,3,4,8,8};
        System.out.println(findMajority(arr, arr.length));//majority element more than n/2 times
    }
    static int findMajority(int [] arr,int n){
        for (int i=0;i<n;i++){
            int count=1;
            for (int j=i+1;j<n;j++){
                if (arr[i]==arr[j])
                    count++;
            }
            if (count>n/2);
            return i;
        }
        return -1;
    }
}
