package com.manindra.leetcodeEasy;

import java.util.HashMap;
import java.util.Map;

/*
input : nums =[1,2,3,2]
o/p =4
Explanation : the unique elements are [1,3] , and the sum is 4
 */
public class SumOfUniqueElement { //solution 1748

    public static void main(String[] args) {

        int [] nums={1,2,3,2};
        System.out.println(sumOfUnique(nums));
    }

    static int sumOfUnique(int [] nums){

        Map<Integer,Integer> frequencyMap=new HashMap<>();

        //count the frequency of each element in the array
        for (int num : nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }

        int sum=0;

        //sum of unique elements (element with frequency 1)
        for (Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()){
            if (entry.getValue()==1){
                sum+= entry.getKey();
            }
        }
        return sum;
    }
}
