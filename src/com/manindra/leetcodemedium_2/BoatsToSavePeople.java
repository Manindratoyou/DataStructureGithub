package com.manindra.leetcodemedium_2;

import java.util.Arrays;

public class BoatsToSavePeople { // solution 881

    public static void main(String[] args) {
        // Test case 1
        int[] people1 = {1, 2};
        int limit1 = 3;
        System.out.println("Number of boats (Test case 1): " + numRescueBoats(people1, limit1));

        // Test case 2
        int[] people2 = {3, 2, 2, 1};
        int limit2 = 3;
        System.out.println("Number of boats (Test case 2): " + numRescueBoats(people2, limit2));

        // Test case 3
        int[] people3 = {3, 5, 3, 4};
        int limit3 = 5;
        System.out.println("Number of boats (Test case 3): " + numRescueBoats(people3, limit3));
    }

    static int numRescueBoats(int[] people, int limit) {
        // Sort the people by weight
        Arrays.sort(people);

        int boats = 0;

        // Use 2 pointers to find the heaviest and lightest person
        int left = 0, right = people.length - 1;

        while (left <= right) {
            // If heaviest and lightest person can fit in the same boat
            if (people[left] + people[right] <= limit) {
                left++;
            }

            // In any case, the heaviest person will be on the boat
            right--;

            // Increment the number of boats
            boats++;
        }

        return boats;
    }
}
