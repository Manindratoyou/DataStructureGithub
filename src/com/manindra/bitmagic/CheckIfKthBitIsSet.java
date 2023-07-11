package com.manindra.bitmagic;

//k<= no of bits in the binary representation of n.
public class CheckIfKthBitIsSet {

    public static void main(String[] args) {
        int n=5,k=1; //n=00...0101 ,output yes
        int n1=8,k1=2; //n=00...1000 ,output no
        int n2=0 ,k2=3; //n=00...0000 output no
        checkIfKthBitIsSetSolOne(5,3);
        checkIfKthBitIsSetSolTwo(5,3);
        checkIfKthBitIsSetSolThree(5,3);
        checkIfKthBitIsSetSolFour(5,3);
    }

    static void checkIfKthBitIsSetSolOne(int n ,int k){ //tc Q(k)
        int x=1;
        for (int i=0;i<(k-1);i++)
            x=x*2;
            if ((n&x)!=0)
                System.out.println("yes");
            else
                System.out.println("NO");
    }
    static void checkIfKthBitIsSetSolTwo(int n ,int k){ //tc Q(k)

        for (int i=0;i<(k-1);i++)
            n=n/2;
        if ((n&1)!=0)
            System.out.println("yes");
        else
            System.out.println("NO");
    }
    static void checkIfKthBitIsSetSolThree(int n ,int k){ //tc Q(k)

        int x=(1<<(k-1));
        if ((n&x)!=0)
            System.out.println("yes");
        else
            System.out.println("NO");
    }
    static void checkIfKthBitIsSetSolFour(int n ,int k){

        int x=(n>>(k-1));
        if ((x&1)!=0)
            System.out.println("yes");
        else
            System.out.println("NO");
    }
}
