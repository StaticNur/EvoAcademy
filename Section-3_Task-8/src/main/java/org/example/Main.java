package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, List<User>> hashMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            String name = scanner.nextLine();
            int age = scanner.nextInt();
            scanner.nextLine();
            if (hashMap.get(age) == null)
                hashMap.put(age, new ArrayList<>(List.of(new User(name, age))));
            else {
                List<User> users = hashMap.get(age);
                users.add(new User(name, age));
            }
        }
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        if (hashMap.get(age) != null) {
            List<User> users = hashMap.get(age);
            Collections.sort(users, new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            for (User user : users) {
                System.out.println(user.toString());
            }
        } else System.out.println("Такого возраста нет в HashMap");
        scanner.close();
    }
}