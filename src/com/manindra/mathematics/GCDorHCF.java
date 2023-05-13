package com.manindra.mathematics;

public class GCDorHCF {

    public static void main(String[] args) {

        System.out.println(gcdSolOne(10,15));
        System.out.println(gcdSolTwo(10,15));
        System.out.println(gcdSolThree(10,15));
    }

    static int gcdSolOne(int a,int b){     //time complexity-O(min(a,b))
        int res=Math.min(a,b);
        while (res>0){
            if (a%res==0 && b%res==0)
                break;
            res--;
        }
        return res;
    }

    //Euclidean algorithm
    static int gcdSolTwo(int a,int b){
      /*  while (a!=b){
            if (a>b)
                a=a-b;
            else
                b=b-a;
        }
        return a;//or b
        */
        while (a!=b)
           return a>b ? (a=a-b) : (b=b-a);
        return 1;
    }

    static int gcdSolThree(int a,int b){
        return b==0 ? a : gcdSolThree(b,a%b);

/*        if (b==0)
            return a;
        else
            return gcdSolThree(b,a%b);*/
    }
}
