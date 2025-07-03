package com.manindra.leetcodemedium_2;

import java.util.Arrays;

public class SuccessfulPairs { //solution 2300

    public static void main(String[] args) {
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        int success = 7;

        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
        // Output: [4, 0, 3]
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        int n = potions.length;

        for (int i = 0; i < spells.length; i++) {
            long minPotion = (success + spells[i] - 1) / spells[i]; // ceil(success / spell)

            int index = binarySearch(potions, minPotion);
            result[i] = n - index;
        }

        return result;
    }

    private static int binarySearch(int[] potions, long target) {
        int low = 0, high = potions.length - 1, ans = potions.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (potions[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int[] successfulPairs2(int[] spells, int[] potions, long success) { //brut force ,Time Limit Exceeded
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int count = 0;
            for (int j = 0; j < potions.length; j++) {
                long product = (long) spells[i] * potions[j];
                if (product >= success) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

}

