package com.manindra.stack_ds;

public class EvaluationOfPostfix {

    public static void main(String[] args) {

        String expression="10 2 * 3 +";
        Evaluate evaluate=new Evaluate(expression.length());
        System.out.println("post fix evaluation "+evaluate.evaluatePostFix(expression));
    }

    static class Evaluate{
        private int top;
        private int capacity;
        private String [] array;

        public Evaluate(int capacity){
            top=-1;
            this.capacity=capacity;
            array=new String[capacity];
        }
        public boolean isEmpty(){
            return top==-1;
        }
        public String peek(){
            return array[top];
        }
        public String pop(){
            if (!isEmpty()){
                top--;
                return array[top+1];
            }else {
                return "$";
            }
        }
        public void push(String op){
            top++;
            array[top]=op;
        }

        public int evaluatePostFix(String expression) {
            String[] tokens = expression.split("\\s+"); // Split expression by spaces
            for (String token : tokens) {
                if (Character.isDigit(token.charAt(0))) {
                    push(token);
                } else {
                    int val2 = Integer.parseInt(pop());
                    int val1 = Integer.parseInt(pop());
                    int result;
                    switch (token) {
                        case "+":
                            result = val1 + val2;
                            break;
                        case "-":
                            result = val1 - val2;
                            break;
                        case "*":
                            result = val1 * val2;
                            break;
                        case "/":
                            result = val1 / val2;
                            break;
                        default:
                            result = 0;
                    }
                    push(String.valueOf(result));
                }
            }
            return Integer.parseInt(pop());
        }

    }
}
