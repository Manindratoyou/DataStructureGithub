package com.manindra.array;

public class Search {

    public static void main(String[] args) {

        int [] arr={20,5,7,25};
        System.out.println(search(arr,5));
    }

    static int search(int [] arr,int key){//O(n) tc
        for (int i=0;i<arr.length;i++){
            if (arr[i]==key)
                return i;
        }
        return -1;
    }
}
