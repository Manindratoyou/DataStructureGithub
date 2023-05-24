package com.manindra.array;

public class DeleteElement {

    public static void main(String[] args) {
        int [] arr={3,8,12,5,6};
        System.out.println(deleteElementFromArray(arr,arr.length,12));
    }

    static int deleteElementFromArray(int [] arr,int arraySize,int key){  // tc Q(n)
        int i;
        for (i=0;i<arraySize;i++)
            if (arr[i]==key)
                break;
        if (i==arraySize)
            return arraySize;
        for (int j=i;j<arraySize-1;j++)
            arr[j]=arr[j+1];
        return arraySize-1;
    }
}
