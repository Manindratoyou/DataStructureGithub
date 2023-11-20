package com.manindra.leetcodeMedium;

import java.util.Arrays;

public class Solution75 { //sort element with 3 element

    public static void main(String[] args) {

        int [] nums1={2,0,2,1,1,0};
        int [] nums2={2,0,1};
        int [] nums3={0};

        System.out.println("before sorting "+ Arrays.toString(nums1));

        //sort(nums1);
        sortDutchNationalFlagAlgorithm(nums1);
        System.out.println("before sorting "+ Arrays.toString(nums1));

        System.out.println("before sorting "+ Arrays.toString(nums2));
        //sort(nums2);
        sortDutchNationalFlagAlgorithm(nums2);
        System.out.println("before sorting "+ Arrays.toString(nums2));

        System.out.println("before sorting "+ Arrays.toString(nums3));
        //sort(nums3);
        sortDutchNationalFlagAlgorithm(nums3);
        System.out.println("before sorting "+ Arrays.toString(nums3));
    }

    static void sort(int [] arr){

        int [] temp=new int[arr.length];
        int i=0;
        for (int j=0;j< arr.length;j++){
            if (arr[j]==0){
                temp[i]=arr[j];
                i++;
            }
        }
        for (int j=0;j< arr.length;j++){
            if (arr[j]==1){
                temp[i]=arr[j];
                i++;
            }
        }
        for (int j=0;j< arr.length;j++){
            if (arr[j]==2){
                temp[i]=arr[j];
                i++;
            }
        }
        for (int j=0;j< arr.length;j++){
            arr[j]=temp[j];
        }
    }

    static void sortDutchNationalFlagAlgorithm(int [] arr){

        int low=0,mid=0,high= arr.length-1;
        while (mid<=high){
            if (arr[mid]==0){
                //swap arr[low] with arr[mid]
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                low++;
                mid++;
            } else if (arr[mid]==1) {  //{0,1,1,0,2,1,0,2}
                mid++;
            }else {
                //swap arr[mid] with arr[high]
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
    }
}
