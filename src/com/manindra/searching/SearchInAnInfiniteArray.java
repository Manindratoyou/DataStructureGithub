package com.manindra.searching;

public class SearchInAnInfiniteArray {

    public static void main(String[] args) {
        int [] arr={1,10,15,20,40,80,100,120,150,200,300,400,100000};//so on
        int key=100;
        System.out.println(searchSolOne(arr,key));
        System.out.println(searchSolTwo(arr,key));
    }

    static int searchSolOne(int [] arr, int key){ //tc 0(position) AS 0(1)
        int i=0;
        while (true){
            if (arr[i]==key) return i;
            if (arr[i]>key) return -1;
            i++;
        }
    }
    static int searchSolTwo(int [] arr, int key){ //tc 0(log(position))

        if (arr[0]==key) return 0;
        int i=1;
        while (arr[i]<key)
            i=i*2;
        if (arr[i]==key) return i;
        return binarySearchRecursive(arr,i/2+1,i-1,key);
    }

    static int binarySearchRecursive(int [] arr,int low,int high,int key){ //tc 0(logn) as:Q(logn) as it required extra space
        if (low>high)
            return -1;
        int mid=(low+high)/2;
        if (arr[mid]==key)
            return mid;
        else if (arr[mid]>key) {
            return binarySearchRecursive(arr, low, mid-1, key);
        }
        else
            return binarySearchRecursive(arr, mid+1, high, key);
    }

}
