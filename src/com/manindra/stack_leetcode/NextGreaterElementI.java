package com.manindra.stack_leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI { //solution 496

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
        //int [] result=nextGreaterElement(nums1,nums2);
        //int[] result = nextGreaterElement2(nums1, nums2);
        //int[] result = nextGreaterElement3(nums1, nums2);
        int[] result = nextGreaterElement4(nums1, nums2);
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

    static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        boolean found = false;
        for (int i = 0; i < nums1.length; i++) {
            found = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    found = true;
                }
                if (found && nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0)
                result[i] = -1;
        }
        return result;
    }

    static int[] nextGreaterElement3(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = map.get(nums1[i]) + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0)
                result[i] = -1;
        }
        return result;
    }

    static int[] nextGreaterElement4(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for (int i : stack) {
            map.put(i, -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
