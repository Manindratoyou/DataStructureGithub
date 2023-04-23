package com.manindra.matrix;

public class SortedMatrix {

    public static void main(String[] args) {

        //i horizontal j vertical
        int[] [] matrix= { {10,20,30,40},
                           {15,25,35,45},
                           {27,29,37,48},
                           {32,33,39,51}
                         } ;

        search(matrix, matrix.length, 32);
    }

    static void search(int[][] matrix,int lenght,int key){
        int i=0;
        int j=lenght-1;
        while (i<lenght && j>=0){
            if (matrix[i][j]==key){
                System.out.println("Key found at index  " +i +" " +j);
                return;
            }
            if (matrix[i][j]>key)
                j--;
            else
                i++;
        }
        System.out.println("Key Not found");
    }
}
