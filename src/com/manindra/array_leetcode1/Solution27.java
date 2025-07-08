package com.manindra.array_leetcode1;

/*
Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class Solution27 {

    public static void main(String[] args) {

        Solution27 solution27=new Solution27();
        int [] arr={3,2,2,3};
        int val=3;
        int newLength=solution27.removeElement(arr,val);
        System.out.println("new length of array: "+newLength);
        System.out.print("updated array :[ ");
        for (int i=0;i<newLength;i++){
            System.out.print(arr[i]);
            if (i<newLength-1)
                System.out.print(",");
        }
        System.out.println("]");
    }

    public int removeElement(int [] arr,int val){
        int count=0;//initialize a count to keep track of non-val elements

        for (int i=0;i< arr.length;i++){
            //if the current element is not equal to val ,copy it to the front of the array
            if (arr[i] !=val){
                arr[count]=arr[i];
                count++;
            }
        }
        return count;
    }

}
