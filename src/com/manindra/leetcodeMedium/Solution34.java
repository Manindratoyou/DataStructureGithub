package com.manindra.leetcodeMedium;

import java.util.Arrays;

public class Solution34 { //find first and last position of element in sorted array

    public static void main(String[] args) {

        int [] nums1={5,7,7,8,8,10}; int target=8;
        int [] nums2={3,3,3,3,3}; int target1=3; //op 0,4
        int [] nums3={5,7,7,8,8,10}; int target2=6;
        int [] nums4={}; int target3=0;

        int [] result=searchRangeSolutionOne(nums1,target);
        System.out.println(Arrays.toString(result));
        System.out.println("============");
        int [] result2=searchRangeSolutionOne(nums2,target1);
        System.out.println(Arrays.toString(result2));
        System.out.println("============");
        int [] result3=searchRangeSolutionOne(nums3,target2);
        System.out.println(Arrays.toString(result3));

    }

    //approach 1 : Binary Search(Two passes) Time Complexity: 0(log n) Auxiliary Space: 0(1)
    static int [] searchRangeSolutionOne(int [] nums,int target){

        int left=findLeftBound(nums,target);
        int right=findRightBound(nums,target);
        return new int[]{left,right};
    }

    private static int findLeftBound(int[] nums, int target) {

        int index=-1,low=0,high= nums.length-1;

        //standard binary search
        while (low<=high){

            int mid=low+(high-low)/2;
            if (nums[mid]==target){
                index=mid;
                high=mid-1; //look in the left sub array
            } else if (nums[mid]<target) {
                low=mid+1;
            }else
                high=mid-1;
        }
        return index;
    }

    private static int findRightBound(int[] nums, int target) {
        int index=-1,low=0,high= nums.length-1;

        //standard binary search
        while (low<=high){

            int mid=low+(high-low)/2;
            if (nums[mid]==target){
                index=mid;
                low=mid+1; //look in the right sub array
            } else if (nums[mid]<target) {
                low=mid+1;
            }else
                high=mid-1;
        }
        return index;
    }

    //approach 2 : Binary Search(one passes) Time Complexity: 0(log n) Auxiliary Space: 0(1)
    static int [] searchRangeSolutionTwo(int [] nums,int target){

        int [] result={-1,-1};

        int leftIndex=binarySearch(nums,target,true);
        if (leftIndex==-1) return result;

        int rightIndex=binarySearch(nums,target,false);

        result[0]=leftIndex;
        result[1]=rightIndex;

        return result;
    }
    private static int binarySearch(int [] nums ,int target,boolean findLeft){

        int left=0,right=nums.length-1,result=-1;
        while (left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]==target){
                result=mid;
                if (findLeft) right=mid-1;
                else left=mid+1;
            } else if (nums[mid]<target) {
                left=mid+1;
            }else
                right=mid-1;
        }
        return result;
    }

    //approach 2 : Linear SearchTime Complexity: 0(n) Auxiliary Space: 0(1)
    static int [] searchRangeSolutionThree(int [] nums,int target){

        int [] result={-1,-1};

       for (int i=0;i< nums.length;i++){
           if (nums[i]==target){
               result[0]=i;
               break;
           }
       }
        for (int j=nums.length-1;j>=0;j--){
            if (nums[j]==target){
                result[1]=j;
                break;
            }
        }

        return result;
    }

}
