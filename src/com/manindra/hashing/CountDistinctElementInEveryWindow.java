package com.manindra.hashing;

public class CountDistinctElementInEveryWindow {

    public static void main(String[] args) {
        int [] arr={10,20,20,10,30,40,10};
        int k=4;
        printDistinct(arr, arr.length, k);
    }

    static void printDistinct(int [] arr,int n,int k){
        for (int i=0;i<=n-k;i++){
            int count=0;
            for (int j=0;j<k;j++){
                boolean flag=false;
                for (int p=0;p<j;p++)
                    if (arr[i+j]==arr[i+p]){
                        flag=true;
                        break;
                    }
                if (flag==false)
                    count++;
            }
            System.out.println(count);
        }
    }
}
