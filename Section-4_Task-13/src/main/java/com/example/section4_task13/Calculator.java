package com.example.section4_task13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
    @Qualifier("subtractor")
    @Autowired
    private Operation operation;

    public void calc(double a, double b){
        System.out.println(operation.getResult(a,b));
    }
}
