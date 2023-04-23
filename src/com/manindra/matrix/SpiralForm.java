package com.manindra.matrix;

public class SpiralForm {

    public static void main(String[] args) {

        int[] [] matrix= { {1,2,3,4},
                {5,6,7,8 },
                {9,10,11,12},
                {13,14,15,16}
        } ;
        spiralPrint(matrix,4,4);

    }
    static void spiralPrint(int [][] matrix,int row,int column){
        int i,k=0,l=0;
        while (k<row && l<column){
            for (i=l;i<column;i++){
                System.out.print(matrix[k][i] +" ");
            }
            k++;
            for (i=k;i<row;i++){
                System.out.print(matrix[i][column-1] + " ");
            }
            column--;
            if (k<row){
                for (i=column-1;i>=l;i--){
                    System.out.print(matrix[row-1][i] + " ");
                }
                row--;
            }
            if (l<column){
                for (i=row-1;i>=k;i--){
                    System.out.print(matrix[i][l] +" ");
                }
                l++;
            }
        }
    }
}
