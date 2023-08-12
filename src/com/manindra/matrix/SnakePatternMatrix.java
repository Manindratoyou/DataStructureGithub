package com.manindra.matrix;

import java.util.Arrays;

public class SnakePatternMatrix {

    static int R=4,C=4;
    public static void main(String[] args) {

        int [] [] mat={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println("Original Matrix");
        Arrays.stream(mat)
                .forEach(row -> {
                    Arrays.stream(row)
                            .forEach(element -> System.out.print(element + " "));
                    System.out.println();
                });
        System.out.println("Snake Matrix");
        printSnake(mat);
    }

    static void printSnake(int [] [] mat){
        for (int i=0;i<R;i++){
            if (i%2==0){
                for (int j=0;j<C;j++)
                    System.out.print(mat[i][j]+ " ");
            }
            else {
                for (int j=C-1;j>=0;j--)
                    System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
