package com.manindra.dequeue;

public class FirstCircularTourSolutionTwo {
    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    static int printTour(int[] gas, int[] cost) {
        if (gas.length != cost.length || gas.length == 0)
            return -1;

        int n = gas.length;
        PetrolPump[] arr = new PetrolPump[n];

        // Construct petrol pump array from gas and cost arrays
        for (int i = 0; i < n; i++) {
            arr[i] = new PetrolPump(gas[i], cost[i]);
        }

        // Consider first petrol pump as a starting point
        int start = 0;
        int end = 1;
        int currPetrol = arr[start].petrol - arr[start].distance;

        // Run a loop while all petrol pumps are not visited.
        // And we have reached the first petrol pump again with 0 or more petrol.
        while (end != start || currPetrol < 0) {
            // If current amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from the tour
            while (currPetrol < 0 && start != end) {
                currPetrol -= arr[start].petrol - arr[start].distance;
                start = (start + 1) % n;
                if (start == 0)
                    return -1;
            }
            // Add a petrol pump to the current tour
            currPetrol += arr[end].petrol - arr[end].distance;
            end = (end + 1) % n;
        }
        // Return starting point
        return start;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int start = printTour(gas, cost);

        if (start == -1)
            System.out.println("No solution");
        else
            System.out.println("Start = " + start);
    }
}

