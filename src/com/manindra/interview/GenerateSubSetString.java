package com.manindra.interview;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubSetString {

    public static void main(String[] args) {

        String s="ABC";
        List<List<String>> result=subSets(s);
        System.out.println(result);
    }

    static List<List<String>> subSets(String nums){

        List<List<String>> result=new ArrayList<>();
        result.add(new ArrayList<>());
        for (char num: nums.toCharArray()){
            int n=result.size();
            for (int j=0;j<n;j++){
                List<String> temp=new ArrayList<>(result.get(j));
                temp.add(String.valueOf(num));
                result.add(temp);
            }
        }
        return result;
    }
}
