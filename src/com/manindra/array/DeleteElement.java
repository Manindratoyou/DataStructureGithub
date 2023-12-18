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
    static int[] deleteElement(int[] arr, int key) {
        int index = -1;

        // Find the index of the key
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }
        }

        // If the key is not found, return the original array
        if (index == -1) {
            return arr;
        }

        // Create a new array with size one less than the original array
        int[] result = new int[arr.length - 1];

        // Copy elements before the key
        System.arraycopy(arr, 0, result, 0, index);

        // Copy elements after the key
        System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);

        return result;
    }

}
