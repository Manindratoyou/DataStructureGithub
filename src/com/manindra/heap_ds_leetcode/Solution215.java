package com.manindra.heap_ds_leetcode;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution215 { //kth largest element in an array without sorting

    public static void main(String[] args) {

        int [] nums={3,2,1,5,4};
        int k=2;
        System.out.println(findKthLargest(nums,k));
        System.out.println(findKthLargestSolTwo(nums,k));
        System.out.println(findKthLargestSolThree(nums,k));

    }

    static int findKthLargest(int [] nums ,int k){

        TreeSet<Integer> treeSet=new TreeSet<>((a,b)->b-a);

        for (int num : nums){
            treeSet.add(num);
        }

        //extract the kth largest element
        for (int i=0;i<k-1;i++)
            treeSet.pollFirst();

        return treeSet.pollFirst();
    }
    static int findKthLargestSolTwo(int [] nums ,int k){

        //create a max heap
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((o1, o2) -> o2-o1);

        //add element to max heap
        for (int num : nums)
            priorityQueue.add(num);

        //extract the kth largest element
        for (int i=0;i<k-1;i++)
            priorityQueue.poll();

        return priorityQueue.poll();
    }

    static int findKthLargestSolThree(int [] nums,int k){
        int left=0;
        int right=nums.length-1;

        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex==k-1) return nums[pivotIndex];
            else if (pivotIndex<k-1) {
                left=pivotIndex+1;
            }else
                right=pivotIndex-1;
        }

    }

    static int partition(int [] nums,int left,int right){
        int pivot=nums[right];
        int i=left;

        for (int j=left;j<right;j++){
            if (nums[j]>=pivot){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,right);
        return i;
    }

    private static void swap(int [] nums, int i ,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
