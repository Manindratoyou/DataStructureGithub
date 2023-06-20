package com.manindra.sorting;

import java.util.Arrays;

public class CycleSort {

    public static void main(String[] args) {
        int [] arr={20,40,50,10,30};
        //cycleSortDistinct(arr);
        cycleSortSolTwo(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void cycleSortDistinct(int [] arr){

        for (int cycleStart=0;cycleStart<arr.length;cycleStart++){
            int item=arr[cycleStart];
            int position=cycleStart;
            for (int i=cycleStart+1;i<arr.length;i++)
                if (arr[i]<item)
                    position++;
            //swap item and arr[position]
            int temp=item;
            item=arr[position];
            arr[position]=temp;

            while (position!=cycleStart){
                position=cycleStart;
                for (int i=cycleStart+1;i<arr.length;i++)
                    if (arr[i]<item)
                        position++;
                //swap item and arr[position]
                temp=item;
                item=arr[position];
                arr[position]=temp;
            }
        }
    }
    public static void cycleSortSolTwo(int[] arr,int n){

        //count number of memory writes
        int writes=0;

        //traverse array element and put it to on the right place
        for (int cycle_start=0;cycle_start<=n-2;cycle_start++){
            int item=arr[cycle_start];
            //find position where we put the item ,we basically count all smaller element on right side of item.
            int position =cycle_start;
            for (int i=cycle_start+1;i<n;i++)
                if (arr[i]<item)
                    position++;
            //if item is already in correct position
            if (position==cycle_start)
                continue;
            //ignore all duplicate element
            while (item==arr[position])
                position+=1;
            //put the item to its right position
            if (position!=cycle_start){
                int temp=item;
                item=arr[position];
                arr[position]=temp;
                writes++;
            }
            //rotate rest of the cycle
            while (position!=cycle_start){
                position=cycle_start;

                //find position where we put the element
                for (int i=cycle_start+1;i<n;i++)
                    if (arr[i]<item)
                        position+=1;

                //ignore all duplicate element
                while (item==arr[position])
                    position+=1;
                //put the item to its right position
                if (item!=arr[position]){
                    int temp=item;
                    item=arr[position];
                    arr[position]=temp;
                    writes++;
                }
            }
        }
        System.out.println("Writes : "+writes);
    }

}
