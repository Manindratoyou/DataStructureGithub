package com.manindra.array_leetcode1;

public class CapacityToShipPackagesWithinDDays { //solution 1011

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays solution = new CapacityToShipPackagesWithinDDays();

        // Test case 1
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D1 = 5;
        System.out.println("Minimum capacity to ship within " + D1 + " days: " + solution.shipWithinDays(weights1, D1));
        // Expected output: 15

        // Test case 2
        int[] weights2 = {3, 2, 2, 4, 1, 4};
        int D2 = 3;
        System.out.println("Minimum capacity to ship within " + D2 + " days: " + solution.shipWithinDays(weights2, D2));
        // Expected output: 6

        // Test case 3
        int[] weights3 = {1, 2, 3, 1, 1};
        int D3 = 4;
        System.out.println("Minimum capacity to ship within " + D3 + " days: " + solution.shipWithinDays(weights3, D3));
        // Expected output: 3
    }

    int shipWithinDays(int[] weights, int D) {

        int minCap = 0;
        int maxCap = 0;
        for (int weight : weights) {

            minCap = Math.max(minCap, weight);
            maxCap += weight;
        }

        // Apply binary search
        while (minCap < maxCap) {
            int mid = minCap + (maxCap - minCap) / 2;

            // Try to ship with "mid" capacity
            int days = 1;
            int sum = 0;
            for (int weight : weights) {
                if (sum + weight > mid) {
                    days++;
                    sum = 0;
                }
                sum += weight;
            }

            // If more days are required, increase capacity
            if (days > D)
                minCap = mid + 1;
            else
                maxCap = mid;
        }

        return minCap;
    }
}
