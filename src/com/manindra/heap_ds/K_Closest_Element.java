package com.manindra.heap_ds;

public class K_Closest_Element {

    public static void main(String[] args) {

        int[] arr = {10, 15, 7, 3, 4};
        int target = 8;
        int numClosest = 2;
        printKClosest(arr, numClosest, target);
    }

    static void printKClosest(int[] arr, int numClosest, int target) { //tc 0(nk) as o(n)
        // Array to keep track of visited elements
        boolean[] visited = new boolean[arr.length];

        // Loop to find numClosest elements
        for (int i = 0; i < numClosest; i++) {
            int minDiff = Integer.MAX_VALUE;
            int minDiffIndex = -1;

            // Loop through the array to find the closest element that hasn't been visited
            for (int j = 0; j < arr.length; j++) {
                if (!visited[j] && Math.abs(arr[j] - target) < minDiff) {
                    minDiff = Math.abs(arr[j] - target);
                    minDiffIndex = j;
                }
            }

            // Print the closest element
            System.out.println(arr[minDiffIndex]);
            // Mark this element as visited
            visited[minDiffIndex] = true;
        }
    }
}
