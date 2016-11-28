package net.accounting.controller;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by vitalii.nedzelskyi on 29.06.2016.
 */
public class MyCalendar {
    public static void main(String[] args) {

        //Construct d as current date
        GregorianCalendar d = new GregorianCalendar();

        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);

        //Set d to start of the month
        d.set(Calendar.DAY_OF_MONTH, 1);

        int weekday = d.get(Calendar.DAY_OF_WEEK);

        // Get first day of the week
        int firstDayOfWeek = d.getFirstDayOfWeek();

        //determine the required indentation for the first line
        int indent = 0;
        while (weekday != firstDayOfWeek){
            indent++;
            d.add(Calendar.DAY_OF_MONTH, -1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }

        // Print weekday names
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%3s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek);
        System.out.println();

        for (int i = 0; i <= indent ; i++)
            System.out.print("  ");

        d.set(Calendar.DAY_OF_MONTH, 1);

        do {
            //print day
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day);

            //mark current day with *
            if (day == today)  System.out.print("*");
            else System.out.print("");

            //advance d to the nex day
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);

            //start new line for the next week
            if (weekday == firstDayOfWeek) {
                System.out.println();
            }
        } while (d.get(Calendar.MONTH) == month);
            // the loop exist when d is day 1 of the next month

            // print final End of line if necessary
        if (weekday != firstDayOfWeek) System.out.println();

    }
}
