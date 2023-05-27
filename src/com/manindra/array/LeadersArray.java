package com.manindra.array;

public class LeadersArray {

    public static void main(String[] args) {

        int [] arr={7,10,4,3,6,5,2};
       // leadersSolOne(arr);
        leadersSolTwo(arr);
    }

    static void leadersSolOne(int [] arr){
        for (int i=0;i< arr.length;i++){
            boolean flag=false;
            for (int j=i+1;j< arr.length;j++){
                if (arr[i]<arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag==false)
                System.out.print(arr[i] +" ");
        }
    }
    static void leadersSolTwo(int [] arr){

        int current_leader=arr[arr.length-1];
        System.out.print(current_leader+" ");
        for (int i= arr.length-1;i>=0;i--){
            if (current_leader<arr[i]) {//arr[i]>current_leader
                current_leader = arr[i];
                System.out.print(current_leader+" ");
            }
        }
    }
}
