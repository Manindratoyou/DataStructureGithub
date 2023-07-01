package com.manindra.test;

class Base{
    public void print(){
        System.out.println("base");
    }
}
class Derived extends Base{
    public void print(){
        System.out.println("derived");
    }
}
public class Test {

    public static void doPrint(Base o){
        o.print();
    }
    public static void main(String[] args) {
        Base x=new Base();
        Base y=new Derived();
        Derived z=new Derived();
        doPrint(x);
        doPrint(y);
        doPrint(z);
    }
}

