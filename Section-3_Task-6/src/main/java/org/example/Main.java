package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        User user1 = new User(name, age);

        scanner.nextLine();
        name = scanner.nextLine();
        age = scanner.nextInt();
        User user2 = new User(name, age);

        if (user1.getAge() < user2.getAge())
            System.out.println(user1.toString());
        else System.out.println(user2.toString());
        scanner.close();
    }
}