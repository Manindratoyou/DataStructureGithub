package com.manindra.stack_ds;

//solution 1 divide the space into two halves
public class TwoStackNaive {

    public static void main(String[] args) {

        TwoStackNaive twoStacks=new TwoStackNaive(5);

        twoStacks.push1(10);
        twoStacks.push1(20);
        twoStacks.push2(30);
        twoStacks.push2(40);

        System.out.println("Popped from Stack 1: " + twoStacks.pop1());
        System.out.println("Popped from Stack 2: " + twoStacks.pop2());


    }

    int [] arr;
    int capacity;
    int top1,top2;

    TwoStackNaive(int n){
        capacity=n;
        arr=new int[n];
        top1=n/2;
        top2=n/2;
    }

    void push1(int x){
        if (top1>0){
            top1--;
            arr[top1]=x;
        }
        else {
            System.out.println("stack overflow by element" +x);
            return;
        }
    }

    void push2(int x){
        if (top2<capacity-1){
            top2++;
            arr[top2]=x;
        }else {
            System.out.println("Stack Overflow by element");
            return;
        }
    }

    int pop1(){
        if (top1<=capacity/2){
            int x=arr[top1];
            top1++;
            return x;
        }else {
            System.out.println("Stack underflow");
            System.exit(1);
        }
        return 0;
    }

    int pop2(){
        if (top2>=capacity/2+1){
            int x=arr[top2];
            top2--;
            return x;
        }else {
            System.out.println("Stack underflow");
            System.exit(1);
        }
        return 0;
    }

}
