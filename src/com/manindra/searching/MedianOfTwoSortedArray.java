package com.manindra.searching;

import java.util.Arrays;

public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        int [] arr1={10,20,30,40,50};
        int [] arr2={5,15,25,35,45};
        //output :27.5 ->{5,10,15,20,25,30,35,40,45,50} ==>25,30 ==>27.5
        int [] arr3={10,20,30,40,50,60};
        int [] arr4={1,2,3,4,5};
        //output 10.0 ->{1,2,3,4,5,10,20,30,40,50}  ==>10==>10.0
        System.out.println(medianOfTwoSortedArraySolOne(arr1,arr2));
        System.out.println(medianOfTwoSortedArraySolTwo(arr1,arr2));
    }

    static double medianOfTwoSortedArraySolOne(int [] arr1,int [] arr2){ //0(n1+n2)*log(n1+n2)
        int i;
        int temp [] =new int[arr1.length+arr2.length];
        for (i=0;i<arr1.length;i++)
            temp[i]=arr1[i];
        for (int j=0;j<arr2.length;j++) {
            temp[i] = arr2[j];
            i++;
        }
        Arrays.sort(temp);
        if (temp.length %2==0) {
            int mid= temp.length/2;
            return (temp[mid]+temp[mid-1])/2;
        }
        else{
            int mid=temp.length/2;
            return temp[mid];
        }
    }
    static double medianOfTwoSortedArraySolTwo(int [] arr1,int [] arr2){ //0(logn)

        int n1=arr1.length,n2= arr2.length;
        int begin1=0,end1=n1;
        while (begin1<=end1){
            int i1=(begin1+end1)/2;
            int i2=((n1+n2+1)/2 - i1);

            int min1=(i1==n1) ? Integer.MAX_VALUE : arr1[i1];
            int max1=(i1==0) ? Integer.MIN_VALUE :arr1[i1-1];

            int min2=(i2==n2) ? Integer.MAX_VALUE :arr2[i2];
            int max2=(i2==0) ? Integer.MIN_VALUE : arr2[i2-1];

            if (max1<=min2 && max2<=min1){
                if ((n1+n2) %2==0)
                    return (Math.max(max1,max2) + Math.min(min1,min2))/2;
                else
                    return Math.max(max1,max2);
            } else if (max1>min2)
                end1=i1-1;
            else
                begin1=i1+1;
        }
        return -1;
    }
}
