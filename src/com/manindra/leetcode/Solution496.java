package com.manindra.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution496 { //Next Greater Element I

    /*
    Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
     */

    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int [] result=nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(result));

    }

    static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if (nums2.length == 0 || nums1.length == 0)
            return new int[0];

        Map<Integer, Integer> numberNGE = new HashMap<>();
        Stack<Integer> numStack = new Stack<>();

        numStack.push(nums2[nums2.length - 1]);
        numberNGE.put(nums2[nums2.length - 1], -1);

        for (int i = nums2.length - 2; i >= 0; i--) {

            if (nums2[i] < numStack.peek()) {
                numberNGE.put(nums2[i], numStack.peek());
                numStack.push(nums2[i]);
                continue;
            }

            while (!numStack.isEmpty() && numStack.peek() < nums2[i])
                numStack.pop();

            if (numStack.isEmpty()) {
                numStack.push(nums2[i]);
                numberNGE.put(nums2[i], -1);
            } else {
                numberNGE.put(nums2[i], numStack.peek());
                numStack.push(nums2[i]);
            }
        }

        for (int i = 0; i < nums1.length; i++)
            nums1[i] = numberNGE.get(nums1[i]);

        return nums1;
    }
}
