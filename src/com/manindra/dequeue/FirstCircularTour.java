package com.manindra.dequeue;


public class FirstCircularTour {

    // Driver code
    public static void main(String[] args) {
        PetrolPump[] arr = {new PetrolPump(6, 4), new PetrolPump(3, 6), new PetrolPump(7, 3)};

        int n = arr.length;
        int start = printTour(arr, n);

        if (start == -1)
            System.out.println("No solution");
        else
            System.out.println("Start = " + start);
    }


    // The function returns starting point if there is a possible solution,
    // otherwise returns -1
    static int printTour(PetrolPump[] arr, int n) {
        // Consider first petrol pump as a starting point
        int start = 0;
        int end = 1;

        int currPetrol = arr[start].petrol - arr[start].distance;

        /* Run a loop while all petrol pumps are not visited.
        And we have reached first petrol pump again with 0 or more petrol */
        while (end != start || currPetrol < 0) {
            // If current amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from tour
            while (currPetrol < 0 && start != end) {
                // Remove starting petrol pump. Change start
                currPetrol -= arr[start].petrol - arr[start].distance;
                start = (start + 1) % n;

                // If 0 is being considered as start again, then there is no
                // possible solution
                if (start == 0)
                    return -1;
            }

            // Add a petrol pump to current tour
            currPetrol += arr[end].petrol - arr[end].distance;

            end = (end + 1) % n;
        }

        // Return starting point
        return start;
    }

    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }
}

