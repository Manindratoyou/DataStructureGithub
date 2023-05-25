package com.manindra.array;

public class SecondLargest {

    public static void main(String[] args) {
        int [] arr={10,5,80,20};
        //int [] arr={10,10,10};
        System.out.println(getSecondLargestSolOne(arr,arr.length));
        System.out.println(getSecondLargestSolTwo(arr,arr.length));
    }

    static int getSecondLargestSolOne(int [] arr,int n){
        int largest=getLargest(arr,n);
        int result=-1;
        for (int i=0;i<n;i++){
            if (arr[i]!=arr[largest]){
                if (result==-1)
                    result=i;
                else if (arr[i]>arr[result]) {
                    result=i;
                }
            }
        }
        return result;
    }
    static int getLargest(int [] arr,int n){
        int largest=0;
        for (int i=0;i<arr.length;i++)
            if (arr[i]>arr[largest])
                largest=i;
        return largest;
    }

    static int getSecondLargestSolTwo(int [] arr,int n) { //tc Q(n) as(Q1)
        int result=-1,largest=0;
        for (int i=1;i<n;i++){
            if (arr[i]>arr[largest]){
                result=largest;
                largest=i;
            } else if (arr[i]!=arr[largest]) {
                if (result==-1 || arr[i]>arr[result])
                    result=i;
            }
        }
        return result;
    }
}
