package com.manindra.array;

public class Insert {

    public static void main(String[] args) {

        int arr[] = new int[5], capacity = 5, arraySize = 3;

        arr[0] = 5; arr[1] = 10; arr[2] = 20;

        System.out.println("Before Insertion");

        for(int i=0; i < arraySize; i++)
        {
            System.out.print(arr[i]+" ");
        }

        System.out.println();

        int keyToBeInsert = 7, position = 2;

        arraySize = insert(arr, arraySize, keyToBeInsert, capacity, position);

        System.out.println("After Insertion");

        for(int i=0; i < arraySize; i++)
        {
            System.out.print(arr[i]+" ");
        }
}

    static int insert(int [] arr,int arraySize,int key,int capacity,int position){ //O(n) tc
        if (arraySize==capacity)
            return arraySize;
        int index=position-1;
        for (int i=arraySize-1;i>=index;i--)
            arr[i+1]=arr[i];
        arr[index]=key;
        return arraySize+1;

    }
}
