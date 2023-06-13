package com.manindra.sorting;

public class CountInversionInArray {

    public static void main(String[] args) {
        int [] arr={2,4,1,3,5};
        //System.out.println(countInversionSolOne(arr, arr.length));
        System.out.println(countInversionSolTwo(arr,0,arr.length-1));
    }

    static int countInversionSolOne(int [] arr,int n){
        int count=0;
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if (arr[i]>arr[j])
                    count++;
            }
        }
        return count;
    }

    static int countInversionSolTwo(int [] arr,int low,int high){
        int result=0;
        if (low<high){
            int mid=(low+high)/2;
            result+=countInversionSolTwo(arr, low, mid);
            result+=countInversionSolTwo(arr, mid+1, high);
            result+=countAndMerge(arr,low,mid,high);
        }
        return result;
    }

    private static int countAndMerge(int[] arr, int low, int mid, int high) {
        int n1=mid-low+1,n2=high-mid;
        int [] left=new int[n1];
        int [] right=new int[n2];
        for (int i=0;i<n1;i++)
            left[i]=arr[i+low];
        for (int j=0;j<n2;j++)
            right[j]=arr[mid+1+j];
        int result=0,i=0,j=0,k=low;
        while (i<n1 && j<n2){
            if (left[i]<=right[j])
                arr[k++]=left[i++];
            else {
                arr[k++]=right[j++];
                result=result+(n1-i);
            }
        }
        while (i<n1)
            arr[k++]=left[i++];
        while (j<n2)
            arr[k++]=right[j++];
        return result;
    }
}
