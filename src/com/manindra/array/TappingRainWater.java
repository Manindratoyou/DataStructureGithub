package com.manindra.array;

public class TappingRainWater {

    public static void main(String[] args) {
        int [] arr={3,0,1,2,5};
        System.out.println(getWaterSolOne(arr));
    }
    static int getWaterSolOne(int [] arr){
        int result=0;
        for (int i=1;i<arr.length-1;i++){

            int lMax=arr[i];
            for (int j=0;j<i;j++)
                lMax=Math.max(lMax,arr[j]);

            int rMax=arr[i];
            for (int j=i+1;j<arr.length;j++)
                rMax=Math.max(rMax,arr[j]);

            result=result+(Math.min(lMax,rMax)-arr[i]);
        }
        return result;
    }
}
