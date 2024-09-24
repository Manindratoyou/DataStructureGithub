package com.manindra.leetcodemedium_2;

public class KokoEatingBananas { //solution 875

    public static void main(String[] args) {
        // Test case
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        // Create an instance of the class and call the method
        KokoEatingBananas solution = new KokoEatingBananas();
        int result = solution.minEatingSpeedBruteForce(piles, h);

        // Print the result
        System.out.println("Minimum eating speed to finish bananas in " + h + " hours: " + result);
    }

    // Function to find the minimum eating speed using brute force
    public int minEatingSpeedBruteForce(int[] piles, int h) {
        // Start with the minimum possible eating speed k = 1
        int k = 1;

        // Continue increasing k until we find a value where Koko can finish in h hours
        while (true) {
            if (canFinish(piles, h, k)) {
                return k; // This is the minimum speed at which Koko can finish the bananas
            }
            k++; // Increment the speed and check again
        }
    }

    // Helper function to check if Koko can finish all bananas within `h` hours at speed `k`
    private boolean canFinish(int[] piles, int h, int k) {
        int hoursSpent = 0;

        for (int pile : piles) {
            // Calculate how many hours it takes to finish each pile with speed `k`
            hoursSpent += (pile + k - 1) / k; // Equivalent to Math.ceil(pile / k)
        }

        return hoursSpent <= h; // Return true if Koko can finish in `h` or fewer hours
    }

    int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;

        // Find max pile size
        int maxSpeed = 0;
        for (int pile : piles)
            maxSpeed = Math.max(maxSpeed, pile);

        // Binary search
        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;

            if (canEatInTime(piles, h, mid))
                maxSpeed = mid;
            else
                minSpeed = mid + 1;
        }

        return minSpeed;
    }

    private boolean canEatInTime(int[] piles, int h, int speed) {
        int hours = 0;
        for(int pile : piles)
            hours += (int) Math.ceil((double) pile / speed);

        return hours <= h;
    }
}

