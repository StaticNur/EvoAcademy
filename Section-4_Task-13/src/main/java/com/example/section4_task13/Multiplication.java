package com.example.section4_task13;

import org.springframework.stereotype.Component;

@Component
public class Multiplication implements Operation{
    @Override
    public double getResult(double a, double b) {
        return a*b;
    }
}
