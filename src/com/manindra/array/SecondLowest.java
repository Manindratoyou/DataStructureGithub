package com.manindra.array;

import java.util.Arrays;

public class SecondLowest {

    public static void main(String[] args) {

        int [] arr={-1,-10,20,42,-13,0,100};
        System.out.println(secondSmallest(arr));
        System.out.println(secondSmallestSolutionTwo(arr));

    }

    static int secondSmallest(int [] arr){ //TC O(n log n) AS: 0(1)

        Arrays.sort(arr);

        return arr[1];
    }
    static int secondSmallestSolutionTwo(int [] arr){ ////TC O(n) AS: 0(1)

        int lowest=Integer.MAX_VALUE;
        int secondLowest=Integer.MAX_VALUE;

        for (int i=0;i<arr.length;i++){
            if (arr[i]<lowest){
                secondLowest=lowest;
                lowest=arr[i];
            }else if (arr[i] < secondLowest && arr[i] != lowest) {
                secondLowest = arr[i];
            }
        }
        return secondLowest;
    }
}
