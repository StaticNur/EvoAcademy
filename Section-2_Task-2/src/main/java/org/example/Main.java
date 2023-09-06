package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if ((a % 5 != 0) && (b % 5 != 0) && (c % 5 != 0))
            System.out.println("нет значений, кратных 5");
        if ((a % 5 == 0) && ((b % 5 == 0) || (c % 5 == 0)))
            System.out.print("a=" + a + ", ");
        else if ((a % 5 == 0) && ((b % 5 != 0) && (c % 5 != 0)))
            System.out.print("a=" + a);
        if ((b % 5 == 0) && (c % 5 == 0))
            System.out.print("b=" + b + ", ");
        else if (b % 5 == 0)
            System.out.print("b=" + b);
        if (c % 5 == 0)
            System.out.print("c=" + c);
        System.out.println("\n" + a / b);
        System.out.println(((double) a / (double) b));
        System.out.println((int) Math.ceil((double) a / b));
        System.out.println((int) Math.floor((double) a / b));
        System.out.println(Math.round((float) a / b));
        System.out.println(b % c);
        System.out.println(Math.min(a, b));
        System.out.println(Math.max(b, c));
    }
}