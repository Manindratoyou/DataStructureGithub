package com.manindra.leetcode;

public class Solution67 {

    public static void main(String[] args) {

        Solution67 solution67=new Solution67();
        String a="1010";
        String b="1011";
        System.out.println("Inputs are : "+ a+" and "+b);
        String result=solution67.addBinary(a,b);
        System.out.println("Binary sum : "+result);
        System.out.println("================");
        System.out.println("Inputs are : "+ a+" and "+b);
        String result1=solution67.add_Binary(a,b);
        System.out.println("Binary sum : "+result1);
    }

    public String addBinary(String a,String b){
        StringBuilder builder=new StringBuilder();
        int carry=0;
        int i=a.length()-1;
        int j=b.length()-1;

        while (i>=0 || j>=0 || carry>0){
            int sum=carry;
            if (i>=0)
                sum+=a.charAt(i--)-'0';
            if (j>=0)
                sum+=b.charAt(j--)-'0';

            builder.insert(0,sum%2);
            carry=sum/2;
        }
        return builder.toString();
    }

     String add_Binary(String x, String y) {

        int num1 = Integer.parseInt(x, 2);
        // converting binary string into integer(decimal
        // number)

        int num2 = Integer.parseInt(y, 2);
        // converting binary string into integer(decimal
        // number)

        int sum = num1 + num2;
        // Adding those two decimal numbers and storing in
        // sum

        String result = Integer.toBinaryString(sum);
        // Converting that resultant decimal into binary
        // string

        return result;
    }
}
