package com.manindra.array;

public class MoveZeroLast {

    public static void main(String[] args) {

        int [] arr={8,1,0,2,1,0,3};
        //moveZero(arr, arr.length);
       // moveZeroToEndSolOne(arr, arr.length);
        moveZeroToEndSolTwo(arr, arr.length);
        printArray(arr);
    }
    static void moveZeroToEndSolOne(int [] arr,int n){ //tc O(n2)
        for (int i=0;i<n;i++){
            if (arr[i]==0){
                for (int j=i+1;j<n;j++){
                    if (arr[j]!=0) {
                        // swap(arr[i],arr[j]);
                        int temp = arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
        }
    }
    static void moveZeroToEndSolTwo(int [] arr,int n){ //tc O(n) as O(1)
        int count =0;
        for (int i=0;i<n;i++){
            if (arr[i]!=0){
                int temp = arr[i];
                arr[i]=arr[count];
                arr[count]=temp;
                count++;
            }
        }
    }

    static void moveZero(int[] arr,int n){
        int j=0;
        for (int i=0;i<n;i++){
            if (arr[i] !=0 && arr[j]==0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            if (arr[j]!=0)
                j++;
        }
    }
    static void printArray(int[] arr){
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

}
