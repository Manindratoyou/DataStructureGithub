package com.manindra.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrintNByKOccurance {

    public static void main(String[] args) {

        int[] arr = {30, 10, 20, 20, 10, 20, 30, 30};//how many number appear more than n/k times
        int k = 4;
        printNBYK(arr, arr.length, k);
        System.out.println("--");
        printNBYKSolTwo(arr, arr.length, k);
        System.out.println("--");
        printNBYKSolThree(arr, arr.length, k);
    }

    static void printNBYK(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int i = 1, count = 1;
        while (i < n) {
            while (i < n && arr[i] == arr[i - 1]) {
                count++;
                i++;
            }
            if (count > n / k)
                System.out.println(arr[i - 1]);
            count = 1;
            i++;
        }
    }

    static void printNBYKSolTwo(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > n / k)
                System.out.println(e.getKey());
        }
    }

    static void printNBYKSolThree(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]);
                map.put(arr[i], count + 1);
            } else if (map.size() < k - 1) {
                map.put(arr[i], 1);
            } else {
                for (Map.Entry<Integer, Integer> x : map.entrySet()) {
                    Integer c = x.getValue();
                    map.put(x.getKey(), c - 1);
                    if (x.getKey() == 0)
                        map.remove(x.getKey());
                }
            }
        }
        for (Map.Entry<Integer,Integer> x:map.entrySet()){
            int count=0;
            for (int i=0;i<n;i++){
                if (x.getKey()==arr[i])
                    count++;
            }
            if (count>n/k)
                System.out.println(x.getKey());
        }
    }
}
