package com.manindra.sorting;

import java.util.Arrays;

public class MeetingMaxiumGuest {

    public static void main(String[] args) {
        int [] arrivalGuest={900,940};
        int [] depGuest={1000,1030};
        System.out.println(meetingMaxGuest(arrivalGuest,depGuest));
    }
    static int meetingMaxGuest(int [] arivalGuest,int [] depGuest){
        Arrays.sort(arivalGuest);
        Arrays.sort(depGuest);

        int i=1,j=0,result=1,current=1;
        while (i< arivalGuest.length && j< depGuest.length){
            if (arivalGuest[i]<depGuest[j]){
                current++;
                i++;
            }else {
                current--;
                j++;
            }
            result=Math.max(current,result);
        }
        return result;
    }
}
