package com.manindra.array;

public class ResizeArray {
    public static void main(String[] args) {

        int [] arr={3,1,4,8,65,45};
        resizeArry(arr,10);
        printArray(arr);

    }

    static int[] resizeArry(int [] arr,int capacity){
        int [] temp=new int[capacity];
        for (int i=0;i< arr.length;i++){
            temp[i]=arr[i];
        }
        arr=temp;
        System.out.println(temp.length);
        return arr;//directly we can return temp here i.e return temp;
    }
    static void printArray(int[] arr){
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
