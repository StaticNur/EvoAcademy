package org.example;

import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        int a = 10000000;
        int b = 1000000000;
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        System.out.println("Ответ: " + LongStream.range(a,b).sum());
    }
}