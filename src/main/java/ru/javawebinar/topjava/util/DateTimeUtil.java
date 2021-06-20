package ru.javawebinar.topjava.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static boolean isBetweenHalfOpen(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }

    public static boolean isBetweenHalfOpenDate(LocalDate lt, LocalDate startTime, LocalDate endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }

    public static LocalDate parseOrDefaultDateMin(String dateMin){
        if(dateMin == ""){
            return LocalDate.MIN;
        }
        return LocalDate.parse(dateMin);
    }
    public static LocalDate parseOrDefaultDateMax(String dateMax){
        if(dateMax == ""){
            return LocalDate.MAX;
        }
        return LocalDate.parse(dateMax);
    }
    public static LocalTime parseOrDefaultTimeMin(String timeMin){
        if(timeMin == ""){
            return LocalTime.MIN;
        }
        return LocalTime.parse(timeMin);
    }
    public static LocalTime parseOrDefaultTimeMax(String timeMax){
        if(timeMax == ""){
            return LocalTime.MAX;
        }
        return LocalTime.parse(timeMax);
    }


    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }
}

