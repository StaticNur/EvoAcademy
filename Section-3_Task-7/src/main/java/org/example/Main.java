package org.example;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String name = scanner.nextLine();
            int age = scanner.nextInt();
            users.add(new User(name, age));
            scanner.nextLine();
        }
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        for (User user : users) {
            System.out.println(user.toString());
        }
        //System.out.println(Arrays.asList(users));
        scanner.close();
    }
}