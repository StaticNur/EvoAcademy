package org.example;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateInput = scanner.nextLine();
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date1 = format.parse(dateInput);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);

            //1
            calendar.add(Calendar.DAY_OF_MONTH, 45);
            Date newDate = calendar.getTime();
            String formattedDate = format.format(newDate);
            System.out.println(formattedDate);

            //2
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            Date shiftedDate = calendar.getTime();
            formattedDate = format.format(shiftedDate);
            System.out.println(formattedDate);


            //3
            calendar.setTime(date1);
            int count = 0;
            while (count < 10) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY)
                    count++;
            }
            newDate = calendar.getTime();
            formattedDate = format.format(newDate);
            System.out.println(formattedDate);


            //4
            calendar.setTime(date1);
            dateInput = scanner.nextLine();
            Date date2 = format.parse(dateInput);
            count = 0;
            while (calendar.getTime().before(date2)) {
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY)
                    count++;
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            System.out.println(count);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        scanner.close();
    }
}