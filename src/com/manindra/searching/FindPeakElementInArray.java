package com.manindra.searching;

public class FindPeakElementInArray { //not smaller than its neighbour
    public static void main(String[] args) {

        int[] arr = {10, 20, 15, 5, 23, 90, 67}; //op should be either 20 or 90
        int[] arr1 = {80, 70, 60}; //op 80
        System.out.println(findPeakElementInArraySolOne(arr));
        System.out.println(findPeakElementInArraySolTwo(arr,arr.length));

    }

    static int findPeakElementInArraySolOne(int [] arr){ //tc 0(n)
        if (arr.length==0) return arr[0];
        if (arr[0]>=arr[1]) return arr[0];
        if (arr[arr.length-1]>=arr[arr.length-2]) return arr[arr.length-1];
        for (int i=1;i<arr.length-1;i++)
            if (arr[i]>=arr[i-1] && arr[i]>=arr[i+1])
                return arr[i];
        return -1;
    }
    static int findPeakElementInArraySolTwo(int [] arr,int n){ //tc 0log(n) As 0(1)
        int low=0,high=n-1;
        while (low<=high){
            int mid=(low+high)/2;
            if (mid==0 || arr[mid-1]<=arr[mid] &&
                mid==n-1 || arr[mid+1]<=arr[mid])
                return arr[mid];//return mid;
            if (mid>0 && arr[mid-1]>=arr[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}
