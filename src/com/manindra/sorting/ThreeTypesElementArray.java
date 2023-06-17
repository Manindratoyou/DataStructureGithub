package com.manindra.sorting;

import java.util.Arrays;

public class ThreeTypesElementArray {

    public static void main(String[] args) {

        int [] arr={0,1,1,2,0,1,0,2};
        //sortSolOne(arr);
        sortDutchNationalFlagAlgo(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sortSolOne(int [] arr){ //tc Q(n) As Q(n)
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
        for (int j=0;j< arr.length;j++)
            arr[j]=temp[j];
    }
    static void sortDutchNationalFlagAlgo(int [] arr){ //tc Q(n) As Q(n)
        int low=0,mid=0,high= arr.length-1;
        while (mid<=high){
            if (arr[mid]==0){
                //swap arr[low] with arr[mid]
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;

                low++;
                mid++;
            } else if (arr[mid]==1) {
                mid++;
            }
            else {
                //swap arr[mid] with arr[high]
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;

                high--;
            }
        }
    }

}
