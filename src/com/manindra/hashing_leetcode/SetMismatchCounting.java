package com.manindra.hashing_leetcode;

public class SetMismatchCounting { //solution 645

    public static void main(String[] args) {
        SetMismatchCounting obj = new SetMismatchCounting();
        int[] nums = {1, 2, 2, 4};
        int[] ans = obj.findErrorNums(nums);
        System.out.println("[" + ans[0] + ", " + ans[1] + "]");
    }

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        int duplicate = -1, missing = -1;

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == 2) {
                duplicate = i;
            } else if (count[i] == 0) {
                missing = i;
            }
        }
        return new int[]{duplicate, missing};
    }
}
