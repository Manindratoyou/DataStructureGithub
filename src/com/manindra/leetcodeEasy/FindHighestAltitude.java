package com.manindra.leetcodeEasy;

public class FindHighestAltitude { //solution 1732

    public static void main(String[] args) {
        int[] gain1 = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain1)); // Output: 1

        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println(largestAltitude(gain2)); // Output: 0
    }

    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;

        for (int g : gain) {
            currentAltitude += g;
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }
}

