package com.manindra.matrix;

public class ExampleThree {

    public static void main2(String[] args) {

        int m=3;
        int [] [] arr=new int[m][];
        for (int i=0;i< arr.length;i++){
            arr[i]=new int[i+1];
            for (int j=0;j< arr[i].length;j++){
                arr[i][j]=i;
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int rows = 3;  // You can change this to generate more rows

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
