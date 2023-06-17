package com.manindra.sorting;

import java.util.Arrays;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        //int [][] arr={{5,10},{3,15},{18,30},{2,7}};
        Interval [] arr={new Interval(7,9),
                         new Interval(6,10),
                         new Interval(4,5),
                         new Interval(1,3),
                         new Interval(2,4)};

        mergeIntervals(arr);
    }

    static void mergeIntervals(Interval [] arr){
        Arrays.sort(arr);
        int result=0;
        for (int i=1;i<arr.length;i++){
            if (arr[result].end >= arr[i].start){

                arr[result].end=Math.max(arr[result].end, arr[i].end);
                arr[result].start=Math.min(arr[result].start, arr[i].start);
            }
            else {
                result++;
                arr[result]=arr[i];
            }
        }
        for (int i=0;i<=result;i++){
            System.out.print("[" +arr[i].start +" ,"+arr[i].end +" ]");
        }
    }

}
