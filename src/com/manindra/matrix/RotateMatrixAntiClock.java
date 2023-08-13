package com.manindra.matrix;

import java.util.Arrays;

public class RotateMatrixAntiClock {

    static int n=4;
    public static void main(String[] args) {

        int [] [] mat={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //rotate90SolOne(mat);
        rotate90SolTwo(mat);
        Arrays.stream(mat).forEach(row->{Arrays.stream(row).forEach(element-> System.out.print(element+" "));
            System.out.println();});
    }

    static void rotate90SolOne(int [] [] mat){
        int [] [] temp=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++)
                temp[n-j-1][i]=mat[i][j];
        }
        //copy temp[][] to mat
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++)
                mat[i][j]=temp[i][j];
        }
    }
    static void rotate90SolTwo(int [] [] mat){
        //transpose
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++)
                swap(mat,i,j);
        }
        //reverse column
        for(int i=0;i<n;i++){
            int low=0,high=n-1;
            while (low<high){
                swap2(low,high,i,mat);
                low++;
                high--;
            }
        }
    }

    static void swap(int [] [] mat,int i,int j){
        int temp=mat[i][j];
        mat[i][j]=mat[j][i];
        mat[j][i]=temp;
    }
    static void swap2(int low,int high,int i,int mat[][]){
        int temp=mat[low][i];
        mat[low][i]=mat[high][i];
        mat[high][i]=temp;
    }
}
