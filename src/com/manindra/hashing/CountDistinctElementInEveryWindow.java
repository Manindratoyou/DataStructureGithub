package com.manindra.hashing;

import java.util.HashMap;

public class CountDistinctElementInEveryWindow {

    public static void main(String[] args) {
        int [] arr={10,20,20,10,30,40,10};
        int k=4;
        printDistinct(arr, arr.length, k);
        printDistinctSolTwo(arr, arr.length, k);
    }

    static void printDistinct(int [] arr,int n,int k){
        for (int i=0;i<=n-k;i++){
            int count=0;
            for (int j=0;j<k;j++){
                boolean flag=false;
                for (int p=0;p<j;p++)
                    if (arr[i+j]==arr[i+p]){
                        flag=true;
                        break;
                    }
                if (flag==false)
                    count++;
            }
            System.out.println(count);
        }
    }
    static void printDistinctSolTwo(int [] arr,int n,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<k;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        System.out.println(map.size()+" ");
        for (int i = k; i < n; i++) {
            map.put(arr[i - k], map.get(arr[i - k]) - 1);
            if (map.get(arr[i - k]) == 0) {
                map.remove(arr[i - k]);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            System.out.print(map.size() + " ");
        }
        System.out.println();
    }
}
