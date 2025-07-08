package com.manindra.array_leetcode1;

public class CanPlaceFlowers { //solution 605

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 1)); // true
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 2)); // false
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;

        for (int i = 0; i < len && n > 0; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeft = (i == 0 || flowerbed[i - 1] == 0);
                boolean emptyRight = (i == len - 1 || flowerbed[i + 1] == 0);

                if (emptyLeft && emptyRight) {
                    flowerbed[i] = 1; // plant a flower
                    n--;              // one less flower to plant
                }
            }
        }

        return n <= 0;
    }
}

