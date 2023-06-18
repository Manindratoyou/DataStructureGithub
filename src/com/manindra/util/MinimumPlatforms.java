package com.manindra.util;

import java.util.Arrays;

public class MinimumPlatforms {

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        //int minPlatforms = findMinPlatforms(arr, dep);
        int minPlatforms = maximumPlateForm(arr, dep);
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
    static int maximumPlateForm(int [] arivalArray,int [] departureArray){ //0(nlogn)
        Arrays.sort(arivalArray);
        Arrays.sort(departureArray);

        int arivalPointer=1,departurePointer=0,maxPlatforms=1,platformsNeeded=1;

        while (arivalPointer< arivalArray.length && departurePointer< departureArray.length){
            if (arivalArray[arivalPointer]<departureArray[departurePointer]){
                platformsNeeded++;
                arivalPointer++;
            }else {
                platformsNeeded--;
                departurePointer++;
            }
            maxPlatforms=Math.max(platformsNeeded,maxPlatforms);
        }
        return maxPlatforms;
    }

}
