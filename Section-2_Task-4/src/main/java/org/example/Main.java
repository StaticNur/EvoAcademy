package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //4.1.
        System.out.println("4.1");
        String str1 = scanner.nextLine();
        String substr = scanner.nextLine();
        String[] array = str1.split(substr);
        System.out.println(array.length - 1);

        //4.2.
        System.out.println("\n4.2");
        String str2 = scanner.nextLine();
        String replacedStr = str2.replaceAll("кака|бяка", "вырезано цензурой");
        System.out.println(replacedStr);

        //4.3.
        System.out.println("\n4.3");
        String str3 = scanner.nextLine();
        String[] date3 = str3.split("\\.");
        System.out.println(date3[2] + "-" + date3[1] + "-" + date3[0]);

        //4.4.
        System.out.println("\n4.4");
        String dateString = scanner.nextLine();
        DateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date4 = inputFormat.parse(dateString);
            String formattedDate = outputFormat.format(date4);
            System.out.println(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}