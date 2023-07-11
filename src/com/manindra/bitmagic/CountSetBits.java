package com.manindra.bitmagic;

public class CountSetBits {

    static int [] table=new int[256];

    public static void main(String[] args) {
        int input=5; //output=2-> 5=101 two set bits here
        int input1=7; //output=3 ->111 three set bits
        System.out.println(countSetBits(7));
        System.out.println(countSetBitsSolTwo(7));
        initialize();
        System.out.println(countSetBitsSolThree(7));
    }

    static int countSetBits(int input){
        int result=0;
        while (input>0){
            /*if (input%2==1)
                result++;*/
            result=result+(input&1);
            input =input/2;
        }
        return result;
    }
    //Brian Kerningam Algorithm
    static int countSetBitsSolTwo(int input){ //tc Q(set bits)
     int result=0;
     while (input>0){
         input=input&(input-1);
         result=result+1;
     }
     return result;
    }

    //look up table solution
    static int countSetBitsSolThree(int input){
        return table[input&255]+
                table[(input>>8) & 255]+
                table[(input>>16) & 255]+
                table[(input>>24)];
    }
    static void initialize(){
        table[0]=0;
        for (int i=1;i<256;i++)
            table[i]=table[i&(i-1)]+1;
    }

}
