package com.manindra.searching;

public class SquareRootFloor {

    public static void main(String[] args) {

        int x=14;
        System.out.println(squareRootFloor(x));
        System.out.println(squareRootFloorSolTwo(x));
    }

    static int squareRootFloor(int number){ //tc Q(sqrt(n)
        int i=1;

        while (i*i<=number)
            i++;

        return i-1;
    }

    static int squareRootFloorSolTwo(int number){ //tc Q(sqrt(n)
        int low=1,high=number,answer=-1;
        while (low<=high){
            int mid=(low+high)/2;
            int midSquare=mid*mid;
            if (midSquare==number)
                return mid;
            else if (midSquare>number) {
                high=mid-1;
            }else {
                low=mid+1;
                answer=mid;
            }
        }
        return answer;
    }
}
