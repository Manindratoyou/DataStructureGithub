package com.manindra.matrix;

import java.util.Arrays;

public class SpiralMatrix {

    public static void main(String[] args) {
        int [] [] mat={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Arrays.stream(mat).forEach(row->{Arrays.stream(row).forEach(element->
                System.out.print(element+" "));System.out.println();});
        System.out.println("======");
        printSpiral(mat,4,4);
    }

    static void printSpiral(int [] [] mat,int R,int C){
        int top=0,left=0,bottom=R-1,right=C-1;
        while (top<=bottom && left<=right){
            //print top row
            for (int i=left;i<=right;i++)
                System.out.print(mat[top][i]+" ");
            top++;
            //print right column
            for (int i=top;i<=bottom;i++)
                System.out.print(mat[i][right]+" ");
            right--;
            if (top<=bottom){
                for (int i=right;i>=left;i--)
                    System.out.print(mat[bottom][i]+" ");
                bottom--;
            }
            if (left<=right){
                for (int i=bottom;i>=top;i--)
                    System.out.print(mat[i][left]+ " ");
                left++;
            }
        }
    }
}
