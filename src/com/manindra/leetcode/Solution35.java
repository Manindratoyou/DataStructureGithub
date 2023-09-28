package com.manindra.leetcode;

public class Solution35 {

    public static void main(String[] args) {

        Solution35 solution35=new Solution35();
        int [] arr={1,3,5,6};
        int target=5;
        //int target=5;
        int result=solution35.searchInsert(arr,target);
        int result1=solution35.searchInsertSolTwo(arr,target);
        System.out.println("Insert position : "+result);
        System.out.println("Insert position : "+result1);
    }

    public int searchInsert(int [] arr,int target){
        int left=0;
        int right=arr.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;
            if (arr[mid]==target)
                return mid;//target found at index mid
            else if (arr[mid]<target) {
                left=mid+1;
            }else
                right=mid-1;
        }
        return left; //target not found ,return the insertion position
    }
    public int searchInsertSolTwo(int [] arr,int target){

        int index=0;
        while (index<arr.length && arr[index]<target)
            index++;
        return index;
    }

}
