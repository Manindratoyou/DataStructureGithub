package com.manindra.leetcodeMedium;

import java.util.Arrays;

public class Solution59 {

    public static void main(String[] args) {

        int [] [] matrix=generateSpiralMatrix(3);
        /*Arrays.stream(matrix)
                .forEach(row -> {
                    Arrays.stream(row)
                            .forEach(element -> System.out.print(element + " "));
                    System.out.println();
                });*/
        printMatrix(matrix);

    }

    static int [] [] generateSpiralMatrix(int n){

        int [] [] matrix=new int[n][n];
        int num=1;

        int rowBegin=0;
        int rowEnd= n-1;
        int colBegin=0;
        int colEnd=n-1;

        while (rowBegin<=rowEnd && colBegin<=colEnd){

            //traverse right
            for (int j=colBegin;j<=colEnd;j++){
                matrix[rowBegin][j]=num++;
            }
            rowBegin++;
            //traverse down
            for (int j=rowBegin;j<=rowEnd;j++){
                matrix[j][colEnd]=num++;
            }
            colEnd--;

            if (rowBegin<=rowEnd){
                //traverse left
                for (int j=colEnd;j>=colBegin;j--){
                    matrix[rowEnd][j]=num++;
                }
            }
            rowEnd--;
            if (colBegin<=colEnd){
                //traverse up
                for (int j=rowEnd;j>=rowBegin;j--){
                    matrix[j][colBegin]=num++;
                }
            }
            colBegin++;
        }
        return matrix;
    }

    static void printMatrix(int [] [] matrix){
        for (int [] row : matrix){
            for (int num: row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
