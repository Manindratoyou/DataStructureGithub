package com.manindra.array_leetcode1;

public class Solution11 { //Container With Most Water

    public static void main(String[] args) {

        int [] arr={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
        System.out.println(maxAreaSolutionTwo(arr));
    }

    static int maxArea(int[] arr) {
        int water = 0, left = 0, right = arr.length-1;

        while(left < right) {
            water = Math.max(water, Math.min(arr[left], arr[right])
                    * (right-left));
            if(arr[left] > arr[right])
                right--;
            else
                left++;
        }
        return water;
    }

    static int maxAreaSolutionTwo(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            int area =
                    Math.min(height[left], height[right])
                            * (right - left);

            maxArea = Math.max(area, maxArea);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

}
