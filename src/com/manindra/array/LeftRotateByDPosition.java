package com.manindra.array;

public class LeftRotateByDPosition {

    public static void main(String[] args) {
        int [] arr={1,2,3,4,5};
        //leftRotateByDPositionSolOne(arr, arr.length, 2);
        //leftRotateByDPositionSolTwo(arr, arr.length, 2);
        leftRotateByDPositionSolThree(arr, arr.length, 2);
        printArray(arr);
    }
    static void leftRotateByDPositionSolOne(int [] arr,int n,int d){ //tc Q(nd) as Q(1)
        for (int i=0;i<d;i++)
            leftRotateOne(arr,n);
    }
    static void leftRotateOne(int[] arr,int n){
        int temp=arr[0];
        for (int i=1;i<n;i++)
            arr[i-1]=arr[i];
        arr[n-1]=temp;
    }
    static void leftRotateByDPositionSolTwo(int [] arr,int n,int d){ //TC-Q(n),AS-Q(d)
        int [] temp=new int[d];
        for (int i=0;i<d;i++)
            temp[i]=arr[i];
        for (int i=d;i<n;i++)
            arr[i-d]=arr[i];
        for (int i=0;i<d;i++)
            arr[n-d+i]=temp[i];
    }
    static void leftRotateByDPositionSolThree(int [] arr,int n,int d){ //TC-Q(n),AS-Q(1)
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }
    static void reverse(int [] arr,int low,int high){
        while (low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
    }





    static void printArray(int[] arr){
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
