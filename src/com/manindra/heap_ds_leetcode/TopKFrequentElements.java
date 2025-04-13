package com.manindra.heap_ds_leetcode;

import java.util.*;

public class TopKFrequentElements { //solution 347

    public static void main(String[] args) {

        int [] nums = {1,1,1,2,2,3};int k = 2;
        int [] result=topKFrequent(nums,k);
        System.out.println(Arrays.toString(result));
    }

    static int[] topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> topK = new ArrayList<>();
        for (int pos = bucket.length - 1;pos >= 0 && topK.size() < k; pos--) {
            if (bucket[pos] != null) {
                topK.addAll(bucket[pos]);
            }
        }

        return topK.stream().mapToInt(i -> i).toArray();
    }

    public int[] topKFrequentSolutionTwo(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];

        int[] topKFrequent = new int[k];

        Map<Integer, Integer> freqs = new HashMap<>();

        for(int num: nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> topFrequent = new PriorityQueue<>((a,b) -> freqs.get(a) - freqs.get(b));

        for(int freq: freqs.keySet()) {
            topFrequent.offer(freq);
        }

        int numItemsToDelete = topFrequent.size() - k;

        for(int i = 1; i <= numItemsToDelete; i++) {
            topFrequent.poll();
        }

        int idx = 0;
        for(int elem: topFrequent) {
            topKFrequent[idx] = elem;
            idx++;
        }

        return topKFrequent;
    }
}
