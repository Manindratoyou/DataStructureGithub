package com.manindra.leetcodemedium_2;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {//solution 904

    public static void main(String[] args) {
        int[] fruits1 = {1, 2, 1};
        int[] fruits2 = {0, 1, 2, 2};
        int[] fruits3 = {1, 2, 3, 2, 2};
        int[] fruits4 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};

        System.out.println(totalFruit(fruits1)); // Expected output: 3
        System.out.println(totalFruit(fruits2)); // Expected output: 3
        System.out.println(totalFruit(fruits3)); // Expected output: 4
        System.out.println(totalFruit(fruits4)); // Expected output: 5
    }

    static int totalFruit(int[] fruits) {

        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxFruits = 0;

        for (right = 0; right < fruits.length; right++) {
            // Add current to basket
            int currentCount = basket.getOrDefault(fruits[right], 0);
            basket.put(fruits[right], currentCount + 1);

            // If basket has more than 2 type of fruits,
            // start emptying the basket
            while (basket.size() > 2) {
                int fruitCount = basket.get(fruits[left]);
                if (fruitCount == 1)
                    basket.remove(fruits[left]);
                else
                    basket.put(fruits[left], fruitCount - 1);
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }

}
