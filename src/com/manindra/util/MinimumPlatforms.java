package com.manindra.util;

import java.util.Arrays;

public class MinimumPlatforms {

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        //int minPlatforms = findMinPlatforms(arr, dep);
        int minPlatforms = meetingMaxGuest(arr, dep);
        System.out.println("Minimum number of platforms required: " + minPlatforms);
    }
    public static int findMinPlatforms(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platformsNeeded = 1;
        int maxPlatforms = 1;
        int i = 1; // Pointer for arrival times
        int j = 0; // Pointer for departure times

        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                platformsNeeded++;
                maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
                i++;
            } else {
                platformsNeeded--;
                j++;
            }
        }

        return maxPlatforms;
    }
    static int meetingMaxGuest(int [] arival,int [] departure){
        Arrays.sort(arival);
        Arrays.sort(departure);

        int i=1,j=0,maxPlatforms=1,platformsNeeded=1;
        while (i< arival.length && j< departure.length){
            if (arival[i]<departure[j]){
                platformsNeeded++;
                i++;
            }else {
                platformsNeeded--;
                j++;
            }
            maxPlatforms=Math.max(platformsNeeded,maxPlatforms);
        }
        return maxPlatforms;
    }

}
