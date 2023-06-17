package com.manindra.sorting;

public class Interval implements Comparable<Interval>{

    int start,end;

    Interval(int start, int end){
        this.start=start;
        this.end=end;
    }


    @Override
    public int compareTo(Interval o) {
        return this.start-o.start;
    }
}
