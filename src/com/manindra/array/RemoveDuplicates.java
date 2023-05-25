package com.manindra.array;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int [] arr={10,20,20,20,20,30,30};
       // System.out.println(removeDuplicatesSolOne(arr,arr.length));
        int n=removeDuplicatesSolTwo(arr, arr.length);
        System.out.println("After Removal");

        for(int i = 0; i < n; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

    static int removeDuplicatesSolOne(int [] arr,int n){// O(n) tc
        int [] temp=new int[n];
        temp[0]=arr[0];
        int result=1;
        for (int i=1;i<n;i++){
            if (temp[result-1]!=arr[i]) {
                temp[result] = arr[i];
                result++;
            }
        }
        for (int i=0;i<result;i++){
            arr[i]=temp[i];

        }
        return result;

    }
    static int removeDuplicatesSolTwo(int [] arr,int n){// O(n) tc
        int result=1;
        for (int i=1;i<n;i++){
            if (arr[i]!=arr[result-1]){
                arr[result]=arr[i];
                result++;
            }
        }
        return result;
    }


}
