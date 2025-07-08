package com.manindra.matrix_leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution54 { //Spiral Matrix

    public static void main(String[] args) {

        int [] [] matrix={{1,2,3,4},
                          {5,6,7,8},
                           {9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }

    static List<Integer> spiralOrder(int [] [] matrix){

        List<Integer> result=new ArrayList<>();

        if (matrix.length==0)
            return result;

        int rowBegin=0;
        int rowEnd= matrix.length-1;
        int colBegin=0;
        int colEnd=matrix[0].length-1;

        while (rowBegin<=rowEnd && colBegin<=colEnd){

            //traverse right
            for (int j=colBegin;j<=colEnd;j++){
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            //traverse down
            for (int j=rowBegin;j<=rowEnd;j++){
                result.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin<=rowEnd){
                //traverse left
                for (int j=colEnd;j>=colBegin;j--){
                    result.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }
            if (colBegin<=colEnd){
                //traverse up
                for (int j=rowEnd;j>=rowBegin;j--){
                    result.add(matrix[j][colBegin]);
                }
                colBegin++;
            }
        }
        return result;
    }
}
