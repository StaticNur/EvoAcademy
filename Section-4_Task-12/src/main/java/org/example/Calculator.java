package org.example;

public class Calculator {
    private final Operation operation;

    public Calculator(Operation operation) {
        this.operation = operation;
    }
    public void calc(double a, double b){
        System.out.println(operation.getResult(a,b));
    }
}
