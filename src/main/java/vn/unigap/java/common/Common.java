package vn.unigap.java.common;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

public class Common {
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String subString(String str, int len) {
        if (str == null) return null;
        return str.substring(0, Math.min(len, str.length()));
    }

    public static String dateToString(LocalDate date, String dateFormat) {
        if (date == null) return null;
        return DateTimeFormatter.ofPattern(dateFormat).format(date);
    }

    public static String dateToString(Date date, String dateFormat) {
        if (date == null) return null;
        return dateToString(dateToLocalDate(date), dateFormat);
    }

    public static LocalDate dateToLocalDate(Date date) {
        if (date == null) return null;
        if (date instanceof java.sql.Date) {
            return ((java.sql.Date) date).toLocalDate();
        }
        return LocalDate.from(date.toInstant());
    }

    public static String timeToString(LocalTime time, String timeFormat) {
        if (time == null) return null;
        return DateTimeFormatter.ofPattern(timeFormat).format(time);
    }

    public static String timeToString(Time time, String timeFormat) {
        if (time == null) return null;
        return timeToString(timeToLocalTime(time), timeFormat);
    }

    public static LocalTime timeToLocalTime(Time time) {
        if (time == null) return null;
        return time.toLocalTime();
    }
}
