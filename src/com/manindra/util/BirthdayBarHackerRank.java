package com.manindra.util;

import java.util.ArrayList;
import java.util.List;

public class BirthdayBarHackerRank {

    public static void main(String[] args) {

        List<Integer> arr=new ArrayList<>();
        arr.add(2);
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(2);

        System.out.println(birthday(arr,4,2));

    }

    public static int birthday(List<Integer> s, int d, int m) {
        int ways = 0;
        int sum = 0;

        if(m <= s.size()) {

            for(int i = 0; i < m; i++)

                sum += s.get(i);

            if(sum == d) ways++;
        }
        for(int i=0;i<s.size()-m;i++){
            sum=sum-s.get(i)+s.get(i+m);
            if(sum==d) ways++;
        }
        return ways;

    }

}
